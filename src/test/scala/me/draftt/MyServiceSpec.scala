package me.draftt

import me.draftt.routing.DrafttService
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class MyServiceSpec extends Specification with Specs2RouteTest with DrafttService {
  def actorRefFactory = system
  
  "MyService" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> drafttRoute ~> check {
        responseAs[String] must contain("{\"val1\":[1,2,3]}")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> drafttRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(drafttRoute) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
