package jp.co.drools.droolsscalaexample

import us.bleibinha.droolsscalaexample.Kie

object HogeDecision extends AutoCloseable {

  val session = Kie.newSession_s("DecisionKS")

  def determine[A](facts: Decision[A]): Decision[A] = {
    session.insert(facts)
    session.fireAllRules()
    facts
  }

  override def close(): Unit = {
    if (session !=null )session.dispose()
  }
}
