package me.draftt.data.access.objects

import me.draftt.data.access.DBAccess
import me.draftt.model.table.StudentTable
import slick.dbio.DBIO
import slick.driver.MySQLDriver.api._
import slick.lifted.TableQuery

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.slick.jdbc.{StaticQuery => Q}

/**
 * Created by oshikawatakashi on 2015/09/30.
 */
object StudentDAO {

  val db = DBAccess.getInstance
  val students = TableQuery[StudentTable]


  def setupDB() = {
    Await.result(db.run(DBIO.seq(
      students.schema.create
    )), Duration.Inf)
    println("DB setup")
  }

  // 全件取得
  def findAll = {
    val q = for (c <- students) yield c.nick_name
    val a = q.result
    val f: Future[Seq[String]] = db.run(a)
    f.onSuccess { case s => println(s"Result: $s") }
  }

  // 生徒IDで生徒を取得
  def findByStudentID(id: Int) = {
    val query = students.map(s => (s.student_id,s.nick_name,s.age))
    db.run(query.result)
  }

  def insert(nick_name: String, age: Int) = {
    val insertActions = DBIO.seq(
      students.map(s => (s.nick_name, s.age)) += (nick_name, age)
    )
    db.run(insertActions)
//    val sql = students.insertStatement
//    println(insertActions)
  }

}
