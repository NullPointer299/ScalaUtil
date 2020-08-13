import util.math.Rational

object Main extends App {

  val sixDividedByTwo = Rational(2, 6)
  val twoDividedByOne = Rational(1, 2)

  val addition = sixDividedByTwo + twoDividedByOne
  val subtraction = sixDividedByTwo - twoDividedByOne
  val multiplication = sixDividedByTwo * twoDividedByOne
  val division = sixDividedByTwo / twoDividedByOne

  println(addition)
  println(subtraction)
  println(multiplication)
  println(division)
}
