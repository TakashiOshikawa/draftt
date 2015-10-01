package me.draftt.data.access.objects

import me.draftt.data.access.DBAccess
import me.draftt.model.table.StudentTable
import slick.dbio.DBIO
import slick.driver.MySQLDriver.api._
import slick.lifted.TableQuery

import scala.concurrent.Await
import scala.concurrent.duration.Duration
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
  def findAll = db.run( students.map( _.* ).result )

  // 生徒IDで生徒を取得
  def findByStudentID(id: Int) = {
    val query = students.map(s => (s.student_id,s.nick_name,s.age))
    db.run(query.result)
  }


  //  def insert(s: Student) = db.withTransaction { implicit session =>
  //    // +? で文字列結合するとエスケープもしてくれる
  //    (Q.u + "INSERT INTO student (nick_name, age) VALUES (" +? s.nick_name + ", " +? s.age + ")").execute
  //  }


}
