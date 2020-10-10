package models

import java.io.FileInputStream
import java.nio.file.Paths
import play.api.libs.json._

class Encoder(var resourcePath: String) {
  val encoderFilePath: String = Paths.get(resourcePath, "tfmodel", "encoder.json").toString
  val encoderFileStream = new FileInputStream(encoderFilePath)

  var encoder: Map[String, Int] = Json.parse(encoderFileStream).as[Map[String, Int]]
  var decoder: Map[Int, String] = encoder.map(_.swap)
}
