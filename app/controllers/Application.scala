package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.{Json}
import lib.Mouse

object Application extends Controller {
  
  def status = Action {
    val ret = Json.obj(
      "status" -> "OK"
    )
    Ok(ret).as("application/json")
  }

  def updatePosition(dx: Option[String], dy: Option[String]) = Action {
    val x = dx match {
      case Some(v) => v.toFloat
      case None => 0
    }

    val y = dy match {
      case Some(v) => v.toFloat
      case None => 0
    }

    Mouse.setRelativePosition(x, y)
    val ret = Json.obj(
      "lastX" -> Mouse.lastX,
      "lastY" -> Mouse.lastY
    )
      Ok(ret).as("application/json")
  }

  def click = Action {
    Mouse.click()
    Ok("{}").as("application/json")
  }
  
}