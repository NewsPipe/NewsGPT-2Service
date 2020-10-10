package models

import java.io.FileInputStream
import java.nio.file.Paths
import play.api.libs.json._

class Encoder(var resourcePath: String) {
  val encoderFilePath: String = Paths.get(resourcePath, "tfmodel", "encoder.json").toString
  val encoderFileStream = new FileInputStream(encoderFilePath)

  var encoder: Map[String, Int] = Json.parse(encoderFileStream).as[Map[String, Int]]
  var decoder: Map[Int, String] = encoder.map(_.swap)

  def encodeText(text: String): Array[Integer] = text.split(" ").map(word => encodeWord(word))

  def encodeWord(word: String): Integer = {
    if (encoder.contains(word)){
      encoder(word)
    }
    else{
      // compare all substrings
    }
  }
}
