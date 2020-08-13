package util.format

/*
  あらゆるものをStringに変換する（予定）クラス

*/

object StringFormatter {

  def arrayToString[T](_array: Array[T]): String = _array.mkString("Array(", ", ", ")")
}
