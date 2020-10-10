package controllers

class GPT2Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def version = Action.async {
    // TODO
  }


  def predict(id: BSONObjectID) = Action.async(parse.json) {
    // TODO
  }

}
