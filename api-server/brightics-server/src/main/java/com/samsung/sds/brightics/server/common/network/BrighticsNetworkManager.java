package com.samsung.sds.brightics.server.common.network;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.samsung.sds.brightics.common.core.exception.BrighticsCoreException;
import com.samsung.sds.brightics.common.core.util.SystemEnvUtil;
import com.samsung.sds.brightics.common.network.NetworkContext;
import com.samsung.sds.brightics.common.core.GrpcMode;
import com.samsung.sds.brightics.common.network.config.NetworkConfig;
import com.samsung.sds.brightics.common.network.sender.MessageSender;
import com.samsung.sds.brightics.common.network.server.NetworkServer;
import com.samsung.sds.brightics.server.common.network.listener.TerminateListener;
import com.samsung.sds.brightics.server.common.network.receiver.CommonReceiver;
import com.samsung.sds.brightics.server.common.network.receiver.TaskReceiver;

@Component
public class BrighticsNetworkManager {

    private static final Logger logger = LoggerFactory.getLogger(BrighticsNetworkManager.class);

    private NetworkServer server;
    private NetworkContext context;
    @Value("${brightics.grpc.mode:remote}")
    private String mode;

    @PostConstruct
    public void start() {
        NetworkConfig networkConfig = NetworkConfig.newConfig().setCheckHeartbeat(true).setHeartbeatTime(1000).setTerminateListener(new TerminateListener());
        System.setProperty("brightics.grpc.mode", mode.toUpperCase());

        if (GrpcMode.getSystemMode() == GrpcMode.LOCAL) {
            context = new NetworkContext("core-server", networkConfig);
        } else {
            String host = SystemEnvUtil.getEnvOrPropOrElse("SERVER_ADDRESS", "server.address", "localhost");
            int port = NumberUtils.toInt(SystemEnvUtil.getEnvOrPropOrElse("SERVER_GRPC_PORT", "brightics.server.grpc.port", ""), 9098);
            context = new NetworkContext(host, port, networkConfig);
        }

        server = context.createNetwork(new CommonReceiver(context), new TaskReceiver());
        server.start();
    }

    @PreDestroy
    public void destroy() {
        server.shutdown();
    }

    public MessageSender getSender(String agentId) {
        MessageSender sender = context.getSender(agentId);
        if (sender == null || sender.isTerminated()) {
            logger.error("Cannot use this agent. agent is terminated.");
            throw new BrighticsCoreException("3002", String.format("agent[%s]", agentId));
        }
        return sender;
    }

    public List<String> getSenderIds() {
        return new ArrayList<>(context.getSenders());
    }
}
