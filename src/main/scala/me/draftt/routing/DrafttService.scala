package me.draftt.routing

import akka.actor.Actor
import me.draftt.data.access.objects.StudentDAO
import me.draftt.model.Auth.{signUpVal, Signup}
import me.draftt.model.Student
import me.draftt.util.DrafttJson
import org.json4s.JsonDSL._
import spray.http.MediaTypes._
import spray.routing._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class DrafttServiceActor extends Actor with DrafttService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(drafttRoute)
}


// this trait defines our service behavior independently from the service actor
trait DrafttService extends HttpService {

  val drafttRoute =
    path("") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            println("res : " + StudentDAO.findAll)
            println("res : " + StudentDAO.findByStudentID(1))
            DrafttJson.make(("val1" -> List(1,2,3)))
          }
        }
      }
    } ~
    path("student" / "signup") {
      formFields('e_mail, 'password) { (e_mail, password) =>
        validate(e_mail.nonEmpty && password.nonEmpty , s"Invalid Request") {
          post {
            val res = Signup.toStudent( signUpVal(e_mail, password) )
            complete(res)
          }
        }
      }
    } ~
    path("student" / "find") {
        get {
          val student = Student.select()
          println("ss" + student)
          complete("ok")
        }
    }
}