package models

import java.nio.file.Paths

import org.tensorflow.{SavedModelBundle, Session, Tensor, Tensors}
import play.api.libs.json.Json

class GPT2(var resourcePath: String) {
  val modelPath: String = Paths.get(resourcePath, "tfmodel").toString

  var loadedModel: Session#Runner = SavedModelBundle.load(modelPath, "serve").session().runner()

  def predict(inputData: Tensor[Integer]): Any = loadedModel
    .feed("Placeholder:0", inputData)
    .fetch("sample_sequence/while/Exit_3:0")
    .run().get(0)


}