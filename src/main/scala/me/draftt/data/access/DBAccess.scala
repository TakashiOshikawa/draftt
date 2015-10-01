package me.draftt.data.access
import slick.driver.MySQLDriver.api._
//import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by oshikawatakashi on 2015/09/29.
 */
object DBAccess {
  private val db = Database.forURL("jdbc:mysql://localhost/draftt?user=scaler&password=scale", driver = "com.mysql.jdbc.Driver")
  def getInstance = db
}
