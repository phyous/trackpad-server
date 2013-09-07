package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.{Json}

object Application extends Controller {
  
  def status = Action {
    val ret = Json.obj(
      "status" -> "OK"
    )
    Ok(ret).as("application/json")
  }
  
}