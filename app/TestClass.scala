import models.Encoder
import models.GPT2
import org.tensorflow.Tensors


object TestClass {

  def main(args: Array[String]): Unit = {
    val resourcePath = getClass.getResource("").getPath
    print(resourcePath)
    val encoder = new Encoder(resourcePath)
    print(encoder.encoder)

    val gpt2 = new GPT2(resourcePath)
    val inputData = Tensors.create(Array(Array(1, 2, 3, 5, 34, 31, 2)))

    var t0 = System.nanoTime()
    gpt2.predict(inputData)
    var t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")

    t0 = System.nanoTime()
    gpt2.predict(inputData)
    t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")

    t0 = System.nanoTime()
    gpt2.predict(inputData)
    t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
  }

}
