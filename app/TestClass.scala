import models.Encoder
import models.GPT2
import org.tensorflow.Tensors


object TestClass {

  def main(args: Array[String]): Unit = {
    val resourcePath = getClass.getResource("").getPath
    print(resourcePath)
    val encoder = new Encoder(resourcePath)
    print(encoder.encoder.get("Hi"))
    val msg = "Hi I just met you, and you are crazy"
    // result should be: [39, 72, 220, 40, 1353, 1251, 293, 11, 295, 293, 448, 1843, 89, 88]
    //val msg = "Hi dasasd, This is a nice biece of sdasdas shit bam bing boom"
    // result should be: [39, 72, 678, 311, 67, 11, 220, 51, 966, 329, 258, 285, 625, 269, 1979, 298, 261, 2535, 2535, 330, 297, 269, 355, 269, 302, 549, 300]
    //val msg = "Thomas arbeitet als Programmierer und führt nebenbei unter dem Pseudonym Neo Jobs als professioneller Hacker aus. Ihn beschleicht das Gefühl, dass etwas Unvorstellbares und Geheimnisvolles sein Leben lenkt. Das Gefühl wird zur Gewissheit, als die Hackerin Trinity ihm den Anführer Morpheus vorstellt."
    // [51, 71, 300, 311, 1785, 314, 685, 220, 47, 360, 994, 1908, 519, 257, 405, 2550, 83, 2973, 1466, 894, 727, 220, 47, 325, 762, 1174, 76, 220, 45, 68, 78, 220, 41, 78, 2064, 685, 3557, 363, 472, 257, 220, 39, 688, 257, 642, 13, 220, 40, 855, 2389, 308, 681, 678, 220, 38, 68, 2922, 1191, 11, 1194, 1662, 311, 220, 52, 77, 2240, 1565, 1364, 272, 405, 220, 38, 68, 431, 328, 2759, 85, 725, 272, 985, 220, 43, 68, 755, 284, 260, 646, 13, 220, 35, 311, 220, 38, 68, 2922, 1191, 954, 1131, 220, 38, 68, 86, 790, 1388, 11, 685, 399, 220, 39, 688, 257, 262, 220, 51, 81, 262, 627, 2722, 555, 220, 32, 77, 2470, 257, 220, 44, 271, 4406, 339, 870, 1565, 83, 13]

    //val gpt2 = new GPT2(resourcePath)
    //val inputData = Tensors.create(Array(Array(1, 2, 3, 5, 34, 31, 2)))

    //print(inputData.)
    /*    var t0 = System.nanoTime()
        gpt2.predict(inputData)
        var t1 = System.nanoTime()
        println("Elapsed time: " + (t1 - t0) + "ns")*/
  }

}
