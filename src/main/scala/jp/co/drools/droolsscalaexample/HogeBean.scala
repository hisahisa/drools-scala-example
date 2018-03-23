package jp.co.drools.droolsscalaexample

import scala.beans.BeanInfo
import scala.collection.mutable.ListBuffer

trait Accesser[A]{
  def set( s: A): Unit
  def get():ListBuffer[A]
}
abstract  class Decision[A]( lst: ListBuffer[A]) extends Accesser[A]

@BeanInfo
case class HogeDecisionBean(id:Int, id2:Int, lst: ListBuffer[Int]) extends Decision[Int](ListBuffer.empty[Int]){
  def set(set: Int) = lst += set
  def get() = lst
}

@BeanInfo
case class FugaDecisionBean(id:Int, lst: ListBuffer[String]) extends Decision[String](ListBuffer.empty[String]){
  def set(s: String) = lst += s
  def get() = lst
}