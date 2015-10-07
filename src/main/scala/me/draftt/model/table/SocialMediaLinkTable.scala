package me.draftt.model.table

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

/**
 * Created by oshikawatakashi on 2015/09/30.
 */

case class SocialMediaLink(socical_media_link_id: Int, student_id: Int, media_link: String, media_name: String, description: String)

class SocialMediaLinkTable(tag: Tag) extends Table[SocialMediaLink](tag, "social_media_link") {

  def socical_media_link_id = column[Int]("socical_media_link_id", O.PrimaryKey)
  def student_id = column[Int]("student_id")
  def media_link = column[String]("media_link")
  def media_name = column[String]("media_name")
  def description = column[String]("description")

  def * = (
    socical_media_link_id,
    student_id,
    media_link,
    media_name,
    description
  ) <> (SocialMediaLink.tupled, SocialMediaLink.unapply)

}
