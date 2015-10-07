package me.draftt.model.table

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

/**
 * Created by oshikawatakashi on 2015/09/30.
 */

case class Deliverable(deliverable_id: Int, student_id: Int, media_link: String, description: String)

class DeliverableTable(tag: Tag) extends Table[Deliverable](tag, "deliverable") {

  def deliverable_id = column[Int]("deliverable_id", O.PrimaryKey)
  def student_id     = column[Int]("student_id")
  def media_link     = column[String]("media_link")
  def description    = column[String]("description")

  def * = (
    deliverable_id,
    student_id,
    media_link,
    description
  ) <> (Deliverable.tupled, Deliverable.unapply)

}
