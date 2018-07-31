# 한글 품사 태깅 도구

[`komoran`](https://github.com/shin285/KOMORAN)을 이용한 한글 품사 태깅 도구

## 1. aws lambda function

vw.ds.nlp.postagger.LambdaRequestHandler

1. `./mvnw clean compile package`

2. upload jar


## 2. CLI 도구

vw.ds.nlp.postagger.PosTaggerCli

1. `./mvnw clean compile package`

2. `java -jar target/pos-tagger-0.0.1.jar "마른 하늘을 달려" "진짜  하나도 모르겠다"`

