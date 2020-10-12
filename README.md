# Newsgen Backend

Newsgen uses Tensorflow Java to run GPT-2 in scala. The whole service is written with Play


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


