package jp.co.drools.droolsscalaexample

/**
  * Created by http://d.hatena.ne.jp/gakuzo/20110630/1309442452
  */
class Loan[T <: {def close()}] private (value: T) {

  def foreach[U](f: T => U): U = try {
    f(value)
  } finally {
    value.close()
  }
}

object Loan {
  def apply[T <: {def close()}](value: T) = new Loan(value)
}