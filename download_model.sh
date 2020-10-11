wget https://github.com/NewsPipe/gpt2-tfx-pipeline/releases/download/0.0.1/tfmodel.zip
unzip tfmodel
cp -r ./tfmodel ./conf/
cp -r ./tfmodel ./test/models/

rm -rf tfmodel
