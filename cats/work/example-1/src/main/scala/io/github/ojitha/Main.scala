package io.github.ojitha

    sealed trait Json
    final case class JsObject(get: Map[String, Json]) extends Json
    final case class JsString(get: String) extends Json
    final case class JsNumber(get: Double) extends Json
    final case object JsNull extends Json

object App extends App {
    println(s"scala version: ${scala.util.Properties.versionString}")
}
