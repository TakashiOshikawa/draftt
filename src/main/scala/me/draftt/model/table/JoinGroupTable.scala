package me.draftt.model.table

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

/**
 * Created by oshikawatakashi on 2015/09/30.
 */

case class JoinGroup(join_group_id: Int, student_id: Int, group_name: String, activity: String)

class JoinGroupTable(tag: Tag) extends Table[JoinGroup](tag, "join_group") {

  def join_group_id = column[Int]("join_group_id", O.PrimaryKey)
  def student_id    = column[Int]("student_id")
  def group_name    = column[String]("group_name")
  def activity      = column[String]("activity")

  def * = (
    join_group_id,
    student_id,
    group_name,
    activity
  ) <> (JoinGroup.tupled, JoinGroup.unapply)

}
