package math

import org.scalatest.funsuite.AnyFunSuite
import util.math.CumulativeSum

class CumulativeSumTest extends AnyFunSuite {

  test("calc test") {
    val _cumulativeSum = CumulativeSum((0 to 10).toArray)

    assert(_cumulativeSum.calc(0, 0) == 0)
    assert(_cumulativeSum.calc(0, 6) == 15)
    assert(_cumulativeSum.calc(0, 11) == 55)
  }

  test("require `_begin` must be smaller than `_end`."){
    assertThrows[IllegalArgumentException]{
      val _cumulativeSum = CumulativeSum((0 to 10).toArray)
      _cumulativeSum.calc(5, 0)
    }
  }
}
