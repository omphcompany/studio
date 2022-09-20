## Format


## Description

본 함수는 Hotelling’s T2 기반 이상 감지 모델을 학습한다. 

---

## Properties
### VA
#### Inputs<b style="color:red">*</b>: table

#### Parameters
1. **Feature Columns**<b style="color:red">*</b>: 피쳐 컬럼
   - Allowed column type : Integer, Long, Double
2. **Confidence Level(0 < value < 1)**: 신뢰 수준(0 < value < 1)
   - Value type : Double
   - Default : 0.01
3. **Number of cluster(s)(1 <= value <= 10)**: 분산 코어 수 (1 <= value <= 10)
   - Value type : Integer
   - Default : 1

#### Outputs: table, table, model

### Python

#### USAGE
```python
from brightics.function.ad import t2Train
res = t2Train(input_table = ,feature_cols = ,alpha = ,cluster = )
res['output_table_score']
res['output_table_cl']
res['output_model']
```

#### Inputs: table

#### Parameters
1. **feature_cols**<b style="color:red">*</b>: 피쳐 컬럼
   - Allowed column type : Integer, Long, Double
2. **alpha**: 신뢰 수준 (0 < value < 1)
   - Value type : Double
   - Default : 0.01
3. **cluster**: 분산 코어 수 (1 <= value <= 10)
   - Value type : Integer
   - Default : 1

#### Outputs: table, table, model
