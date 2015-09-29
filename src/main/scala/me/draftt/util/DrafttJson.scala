package me.draftt.util

import org.json4s
import org.json4s.native.JsonMethods


/**
 * Created by oshikawatakashi on 2015/09/29.
 */
object DrafttJson {

  def make(obj: json4s.JValue) = JsonMethods.compact(JsonMethods.render(obj))

}
