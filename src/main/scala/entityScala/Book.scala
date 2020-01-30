package entityScala

import java.util.UUID

class Book(val title: String, val year: Integer,
           val author: String) {

  private val uuid = UUID.randomUUID().toString.substring(0, 8)
  private var _lenter: String = _
  private var _lentStatus: Boolean = _

  def lenter: String = _lenter
  def lenter_=(lenter: String){
    _lenter = lenter
  }

  def lentStatus: Boolean = _lentStatus
  def lentStatus_=(lentStatus: Boolean){
    _lentStatus = lentStatus
  }

  override def toString() = {
    if (lenter == null) {
      s"$title, $year, $author, $lentStatus, [$uuid]"
    } else {
      s"$title, $year, $author, $lenter, $lentStatus, [$uuid]"
    }
  }
}





