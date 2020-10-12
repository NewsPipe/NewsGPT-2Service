# GPT2 Service in Scala 
A service to generate texts with GPT-2 written in Scala with Tensorflow Java and Play

## Requirements
- Scala 2.12.2
- Python3
- wget

## Getting started

```
git clone
cd newsgen-backend
sh download_model.sh
sbt run
```



## Example request

```
curl -X POST \
  -H "Content-Type: application/json" \
  -v "http://localhost:9000/predict" \
  -d '{"text":"Hi I just met you"}'
```
with output:
```
{"prediction": "..."}
```

