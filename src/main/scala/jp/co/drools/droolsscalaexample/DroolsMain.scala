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
    val ret_hdb = hd.determine(hdb)
    val ret_fdb = hd.determine(fdb)

    ret_confirm(ret_hdb)
    ret_confirm(ret_fdb)

    def ret_confirm[A](facts: Decision[A]):Unit ={
      facts.get().foreach(println(_))
    }
  }

  println("end")
}