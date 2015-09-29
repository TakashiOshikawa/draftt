package me.draftt.model.table

import slick.lifted.Tag
import slick.driver.MySQLDriver.api._

/**
 * Created by oshikawatakashi on 2015/09/30.
 */
class DeliverableTable(tag: Tag) extends Table[(Int, Int, String, String)](tag, "deliverable") {

  def deliverable_id = column[Int]("deliverable_id", O.PrimaryKey)
  def student_id     = column[Int]("student_id")
  def media_link     = column[String]("media_link")
  def description    = column[String]("description")

  def * = (
    deliverable_id,
    student_id,
    media_link,
    description
  )

}
