package me.draftt.model.Auth

import me.draftt.model.Student

/**
 * Created by oshikawatakashi on 2015/10/04.
 */

case class signUpVal(e_mail: String, password: String)

object Signup {

  /**
   *  サインアップ時に最低限必要な項目は
   *  -> mail address
   *  -> password
   *  nick_nameとageは初期設定項目として入れておく
   */

  def toStudent(v: signUpVal): String = {
    (v.e_mail, v.password) match {
      case ("", "") => "faild"
      case (e , "") => "faild"
      case ("", p ) => "faild"
      case (e , p ) => {
        val res = Student.create(e, p)
        "success: " + res + " !"
      }
    }
  }

}
