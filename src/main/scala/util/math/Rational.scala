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
class Rational(_numerator: Int, _denominator: Int) extends Ordered[Rational] {

  require(_denominator != 0, "`_denominator` must be non-zero.")

  // 最大公約数
  private val gcd = calcGcd(_numerator.abs, _denominator.abs)

  // 分子
  val numerator: Int = _numerator / gcd
  // 分母
  val denominator: Int = _denominator / gcd

  def this(_numerator: Int) = this(_numerator, 1)

  def +(numeric: Int): Rational = {
    Rational(numerator + (numeric * denominator), denominator)
  }

  def +(that: Rational): Rational = {
    Rational(
      (this.numerator * that.denominator) + (that.numerator * this.denominator),
      this.denominator * that.denominator)
  }

  def -(numeric: Int): Rational = {
    Rational(numerator - numeric * denominator, denominator)
  }

  def -(that: Rational): Rational = {
    Rational(
      (this.numerator * that.denominator) - (that.numerator * this.denominator),
      this.denominator * that.denominator)
  }

  def *(numeric: Int): Rational = {
    Rational(numerator * numeric, denominator)
  }

  def *(that: Rational): Rational = {
    Rational(this.numerator * that.numerator, this.denominator * that.denominator)
  }

  def /(numeric: Int): Rational = {
    Rational(numerator, denominator * numeric)
  }

  def /(that: Rational): Rational = {
    Rational(this.numerator * that.denominator, this.denominator * that.numerator)
  }

  def calcGcd(num1: Int, num2: Int): Int = {
    if (num2 == 0) num1 else calcGcd(num2, num1 % num2)
  }

  override def compare(that: Rational): Int = {
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
  }

  // TODO 適切に比較する
  override def equals(that: Any): Boolean = {
    if (that == null) false
    else if (!that.isInstanceOf[Rational]) false
    else true
  }

  override def toString: String = {
    if (denominator == 1)
      numerator.toString
    else
      numerator + "/" + denominator
  }
}
