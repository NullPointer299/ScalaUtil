package math

import org.scalatest.funsuite.AnyFunSuite
import util.math.TwoPoint

class TwoPointTest extends AnyFunSuite{

  test("countSumUnder test"){
    val _array1 = Array(5, 3, 8, 6, 1, 4)
    val _twoPoint1=TwoPoint(_array1)

    val _array2 = Array(4, 6, 7, 8, 1, 2, 110, 2, 4, 12, 3, 9)
    val _twoPoint2 = TwoPoint(_array2)

    assert(_twoPoint1.countSumUnder(12) == 11)
    assert(_twoPoint2.countSumUnder(25) == 32)
  }
}
