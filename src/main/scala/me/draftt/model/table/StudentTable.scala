package me.draftt.model.table

import slick.driver.MySQLDriver.api._
import slick.lifted.Tag

/**
 * Created by oshikawatakashi on 2015/09/30.
 */

case class Student(
                  student_id:        Int,
                  e_mail:            String,
                  password:          String,
                  nick_name:         String,
                  age:               Int,
                  hoby:              String,
                  corporate_culture: String,
                  hope_of_companies: String,
                  what_did:          String,
                  want_to_do:        String
                    )

class StudentTable(tag: Tag) extends Table[Student](tag, "student") {

  def student_id        = column[Int]("student_id", O.PrimaryKey)
  def e_mail            = column[String]("e_mail")
  def password          = column[String]("password")
  def nick_name         = column[String]("nick_name")
  def age               = column[Int]("age")
  def hoby              = column[String]("hoby")
  def corporate_culture = column[String]("corporate_culture")
  def hope_of_companies = column[String]("hope_of_companies")
  def what_did          = column[String]("what_did")
  def want_to_do        = column[String]("want_to_do")

  def * = (
    student_id,
    e_mail,
    password,
    nick_name,
    age,
    hoby,
    corporate_culture,
    hope_of_companies,
    what_did,
    want_to_do
  ) <> (Student.tupled, Student.unapply)

}
