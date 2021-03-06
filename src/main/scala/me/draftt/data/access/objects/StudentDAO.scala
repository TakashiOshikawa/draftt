package me.draftt.data.access.objects

import me.draftt.model.table.StudentTable
import slick.dbio.DBIO
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration


/**
 * Created by oshikawatakashi on 2015/09/30.
 */
object StudentDAO extends DAOBase {


  val t = TableQuery[StudentTable]

  /**
   *  CREATE SCHEME
   */
  def setupDB() = {
    Await.result(db.run(DBIO.seq(
      t.schema.create
    )), Duration.Inf)
    println("DB setup")
  }

  /**
   *  INSERT
   */
  // 名前と年齢を取得して学生会員作成
  def insert(e_mail: String, password: String) = {
//    val q = t.map(s => (s.e_mail, s.password)) += (e_mail, password)
    val q = t.map(s => (s.e_mail, s.password)) += (e_mail, password)
    val res = Await.result(db.run(DBIO.seq(
      q
    )), Duration.Inf)
    res
  }


  /**
   *  SELECT
   */
  // 全件取得
  def findAll: Seq[Any] = {
    val q = for (s <- t) yield s.e_mail; q
  }

  // 生徒IDで生徒を取得
  def findByStudentID(id: Int): Seq[Any] = {
    val q = for (s <- t if s.student_id === id) yield (s.student_id, s.e_mail, s.password); q
  }


  /**
   *  UPDATE
   */
  def updateHobyByStudentID(id: Int, hoby: String) = {
    val q = t.filter(_.student_id === id).map( s => s.hoby)
    db.run( DBIO.seq(q.update(hoby)) )
  }


  /**
   *  DELELE
   */
  def deleteByID(id: Int) = {
    val q = t.filter(_.student_id === id).delete
    db.run( DBIO.seq(q) )
  }


  /**
   *  COUNT
   */

}
