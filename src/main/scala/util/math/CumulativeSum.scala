package util.math

/*
  累積和を計算するクラス

  参考文献
  https://qiita.com/drken/items/56a6b68edef8fc605821
*/

object CumulativeSum {
  def apply(_numbers: Array[Int]): CumulativeSum = new CumulativeSum(_numbers)
}

class CumulativeSum(numbers: Array[Int]) {

  private val cumulativeArray = Array.fill(numbers.length + 1)(0)
  for (i <- numbers.indices) cumulativeArray(i + 1) = cumulativeArray(i) + numbers(i)

  def calc(_begin: Int, _end: Int): Int = {
    require(_begin <= _end, "`_begin` must be smaller than `_end`.")
    cumulativeArray(_end) - cumulativeArray(_begin)
  }
}
