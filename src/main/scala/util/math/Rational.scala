package util.math

/*
  分数を表現するクラス

  参考文献
  コップ本6章
 */

object Rational {
  def apply(_numerator: Int, _denominator: Int): Rational = new Rational(_numerator, _denominator)
}

// TODO 分子が負の値になった時の表示を直す
class Rational(_numerator: Int, _denominator: Int) {

  require(_denominator != 0, "`_denominator` must be non-zero.")

  // 最大公約数
  private val gcd = calcGcd(_numerator.abs, _denominator.abs)

  // 分子
  val numerator: Int = _numerator / gcd
  // 分母
  val denominator: Int = _denominator / gcd

  def this(_numerator: Int) = this(_numerator, 1)

  def +(numeric: Int): Rational = {
    Rational(numerator + numeric * denominator, denominator)
  }

  def +(that: Rational): Rational = {
    Rational(numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator)
  }

  def -(numeric: Int): Rational = {
    Rational(numerator - numeric * denominator, denominator)
  }

  def -(that: Rational): Rational = {
    Rational(numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator)
  }

  def *(numeric: Int): Rational = {
    Rational(numerator * numeric, denominator)
  }

  def *(that: Rational): Rational = {
    Rational(numerator * that.numerator, denominator * that.denominator)
  }

  def /(numeric: Int): Rational = {
    Rational(numerator, denominator * numeric)
  }

  def /(that: Rational): Rational = {
    Rational(numerator * that.denominator, denominator * that.numerator)
  }

  def calcGcd(num1: Int, num2: Int): Int = {
    if (num2 == 0) num1 else calcGcd(num2, num1 % num2)
  }

  override def toString: String = {
    if (denominator == 1)
      numerator.toString
    else
      numerator + "/" + denominator
  }
}
