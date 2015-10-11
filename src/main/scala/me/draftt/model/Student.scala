package me.draftt.model

import me.draftt.data.access.objects.StudentDAO

/**
 * Created by oshikawatakashi on 2015/10/04.
 */

object Student {

  def create(e_mail: String, password: String) = {
    val res = StudentDAO.insert(e_mail, password)
    res
  }


}
