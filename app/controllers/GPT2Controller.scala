package controllers

import java.nio.file.Paths

import org.tensorflow.{SavedModelBundle, Tensor, TensorFlow, Tensors}
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}

class GPT2Controller extends BaseController {

/*
  def predict = Action.async(parse.json) {
    // TODO
  }
*/
  override protected def controllerComponents: ControllerComponents = ???
}
