package jp.co.drools.droolsscalaexample

import scala.collection.mutable.ListBuffer

object DroolsMain extends App{
  println("start")
  for {
    // autoclose してくれる inputStream系も使えるのがナイス
    hd <- Loan(HogeDecision)
  } {
    val hdb = HogeDecisionBean(101, 1, ListBuffer.empty)
    val fdb = FugaDecisionBean(2, ListBuffer.empty)
    hd.determine(hdb).get().foreach(println(_))
    hd.determine(fdb).get().foreach(println(_))
  }
  println("end")
}