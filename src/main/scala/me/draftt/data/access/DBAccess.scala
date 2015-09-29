package me.draftt.data.access
import slick.driver.MySQLDriver.api._

/**
 * Created by oshikawatakashi on 2015/09/29.
 */
object DBAccess {
  private val db = Database.forConfig("mysql_info")
  def getInstance(): Database = db
}
