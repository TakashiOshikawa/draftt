package me.draftt

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import me.draftt.routing.DrafttServiceActor
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

object DrafttMain extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")

  // create and start our service actor
  val service = system.actorOf(Props[DrafttServiceActor], "draft-service")

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ? Http.Bind(service, interface = "127.0.0.1", port = 8023)
}
