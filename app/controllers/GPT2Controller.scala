package controllers

import models.{Encoder, GPT2, GPT2Input}
import org.tensorflow.Tensors
import javax.inject._
import play.Environment
import play.api.libs.json._
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class GPT2Controller @Inject()(implicit ec: ExecutionContext,
                               val controllerComponents: ControllerComponents,
                               val env: Environment,
                              ) extends BaseController {

  val resourcePath: String = env.classLoader.getResource("").getPath
  val encoder: Encoder = new Encoder(resourcePath)
  val gpt2: GPT2 = new GPT2(resourcePath)


  def predict: Action[JsValue] = Action(parse.json) { request =>
    val inputData = request.body.validate[GPT2Input]
    inputData.fold(
      errors => {
        BadRequest(Json.obj("message" -> JsError.toJson(errors)))
      },
      input => {
        val prediction = predict_helper(input.text)
        print(prediction)
        Ok(Json.obj(("prediction", prediction)))
      }
    )
  }

  def predict_dummy: Action[JsValue] = Action(parse.json) { request =>
    val inputData = request.body.validate[GPT2Input]
    inputData.fold(
      errors => {
        BadRequest(Json.obj("message" -> JsError.toJson(errors)))
      },
      input => {
        val prediction = "prediction_dummy"
        print(prediction)
        Ok(Json.obj(("prediction", prediction)))
      }
    )
  }

  def predict_helper(text: String): String = {
    val encoded_msg = encoder.encode(text)
    val inputData = Tensors.create(Array(encoded_msg))
    val prediction_tensor = gpt2.predict(inputData)

    val prediction_array = Array.ofDim[Int](1, prediction_tensor.shape()(1).toInt)
    prediction_tensor.copyTo(prediction_array)
    encoder.decode(prediction_array(0))
  }


}
