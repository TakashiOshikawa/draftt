package me.draftt.model.table

import slick.lifted.Tag
import slick.driver.MySQLDriver.api._

/**
 * Created by oshikawatakashi on 2015/09/30.
 */
class JoinGroupTable(tag: Tag) extends Table[(Int, Int, String, String)](tag, "join_group") {

  def join_group_id = column[Int]("join_group_id", O.PrimaryKey)
  def student_id    = column[Int]("student_id")
  def group_name    = column[String]("group_name")
  def activity      = column[String]("activity")

  def * = (
    join_group_id,
    student_id,
    group_name,
    activity
  )

}
