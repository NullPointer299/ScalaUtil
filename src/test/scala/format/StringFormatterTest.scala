package format

import org.scalatest.funsuite.AnyFunSuite
import util.format.StringFormatter

class StringFormatterTest extends AnyFunSuite {

  test("arrayToString test") {
    val _result = StringFormatter.arrayToString(Array("This", "is", "test"))
    assert(_result == "Array(This, is, test)")
  }
}
