package math

import org.scalatest.funsuite.AnyFunSuite
import util.math.Rational

class RationalTest extends AnyFunSuite {

  test("calc gcd test") {
    val sixDividedByTwo = Rational(2, 6)
    assert(sixDividedByTwo.toString == "1/3")
  }

  test("same object calc test") {
    val sixDividedByTwo = Rational(2, 6)

    val addition = sixDividedByTwo + sixDividedByTwo
    val subtraction = sixDividedByTwo - sixDividedByTwo
    val multiplication = sixDividedByTwo * sixDividedByTwo
    val division = sixDividedByTwo / sixDividedByTwo

    assert(addition.toString == "2/3")
    assert(subtraction.toString == "0")
    assert(multiplication.toString == "1/9")
    assert(division.toString == "1")
  }

  test("other object calc test") {
    val sixDividedByTwo = Rational(2, 6)
    val twoDividedByOne = Rational(1, 2)

    val addition = sixDividedByTwo + twoDividedByOne
    val subtraction = sixDividedByTwo - twoDividedByOne
    val multiplication = sixDividedByTwo * twoDividedByOne
    val division = sixDividedByTwo / twoDividedByOne

    assert(addition.toString == "5/6")
    assert(subtraction.toString == "-1/6")
    assert(multiplication.toString == "1/6")
    assert(division.toString == "2/3")
  }

  test("require `_denominator` must be non-zero.") {
    assertThrows[IllegalArgumentException] {
      Rational(5, 0)
    }
  }
}
