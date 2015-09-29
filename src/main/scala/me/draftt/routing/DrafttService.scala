package me.draftt.routing

import akka.actor.Actor
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
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait DrafttService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            DrafttJson.make(("val1" -> List(1,2,3)))
          }
        }
      }
    }
}