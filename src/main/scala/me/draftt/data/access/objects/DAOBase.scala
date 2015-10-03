package me.draftt.data.access.objects

import me.draftt.data.access.DBAccess
import slick.driver.MySQLDriver.api._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
 * Created by oshikawatakashi on 2015/10/03.
 */
trait DAOBase {

  val db = DBAccess.getInstance

  /**
   *  implicit Await.result
   *  引数1     slick.lifted.Query[slick.lifted.Rep[String],String,Seq]
   *  引数1以上  slick.lifted.Query[(slick.lifted.Rep[Int], slick.lifted.Rep[String], slick.lifted.Rep[Int]),(Int, String, Int),Seq]
   */
  type LRep[A] = slick.lifted.Rep[A]

  implicit def awaitDBResult1[A](q: slick.lifted.Query[LRep[A], A, Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult2[A,B](q: slick.lifted.Query[(LRep[A], LRep[B]), (A,B), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult3[A,B,C](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C]), (A,B,C), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult4[A,B,C,D](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D]), (A,B,C,D), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult5[A,B,C,D,E](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E]), (A,B,C,D,E), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult6[A,B,C,D,E,F](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E], LRep[F]), (A,B,C,D,E,F), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult7[A,B,C,D,E,F,G](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E], LRep[F], LRep[G]), (A,B,C,D,E,F,G), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult8[A,B,C,D,E,F,G,H](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E], LRep[F], LRep[G], LRep[H]), (A,B,C,D,E,F,G,H), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult9[A,B,C,D,E,F,G,H,I](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E], LRep[F], LRep[G], LRep[H], LRep[I]), (A,B,C,D,E,F,G,H,I), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

  implicit def awaitDBResult10[A,B,C,D,E,F,G,H,I,J](q: slick.lifted.Query[(LRep[A], LRep[B], LRep[C], LRep[D], LRep[E], LRep[F], LRep[G], LRep[H], LRep[I], LRep[J]), (A,B,C,D,E,F,G,H,I,J), Seq]): Seq[Any] =
    Await.result(db.run(q.result): Future[Seq[Any]], Duration.Inf)

}
