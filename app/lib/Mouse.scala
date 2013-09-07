package lib

import java.awt.{Toolkit, Robot}
import java.awt.event.InputEvent

object Mouse {
  private val robot = new Robot()
  private val screenSize = Toolkit.getDefaultToolkit().getScreenSize()
  private[this] val width = screenSize.getWidth.asInstanceOf[Int]
  private[this] val height = screenSize.getHeight.asInstanceOf[Int]
  var lastX = 0
  var lastY = 0
  var xSensistivity = 1.0
  var ySensistivity = 1.0
  var invertY: Boolean = true

  def centerMouse = {
    robot.mouseMove(width / 2, height / 2)
  }

  def setRelativePosition(x: Float, y: Float) = {
    val xPos = (width / 2) + x * xSensistivity * (width / 2)
    val yOffset = y * ySensistivity * (height / 2)
    val yPos = if (invertY) {
      (height / 2) + yOffset
    } else {
      (height / 2) - yOffset
    }
    lastX = xPos.asInstanceOf[Int]
    lastY = yPos.asInstanceOf[Int]
    robot.mouseMove(xPos.asInstanceOf[Int], yPos.asInstanceOf[Int])
  }

  def click() = {
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    println("Click activated")
  }
}
