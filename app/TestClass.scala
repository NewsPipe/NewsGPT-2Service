import models.Encoder
import models.GPT2
import org.tensorflow.Tensors

import scala.util.matching.Regex


object TestClass {

  def main(args: Array[String]): Unit = {
    val resourcePath = getClass.getResource("").getPath
    val encoder = new Encoder(resourcePath)
    //val gpt2 = new GPT2(resourcePath)

    val msg = "Hi I just met you, and you are crazy"
    val encoded_msg = encoder.encode(msg)
    val decoded_msg = encoder.decode(encoded_msg)
    print(decoded_msg)
    //val inputData = Tensors.create(Array(encoded_msg))
    //val prediction = gpt2.predict(inputData)
    //print(prediction)
  }

}
