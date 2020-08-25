package util.math

import scala.annotation.tailrec

/*
  尺取り法の計算をするクラス
  閾値以下の組み合わせが何通りあるか計算する

  参考文献
  https://qiita.com/drken/items/ecd1a472d3a0e7db8dce
 */

object TwoPoint {
  def apply(numbers: Array[Int]): TwoPoint = new TwoPoint(numbers)
}

class TwoPoint(numbers: Array[Int]) {

    // 命令型版
    def instructionalCountSumUnder(_threshold: Int): Int = {
      var _end = 0
      var _sum = 0
      var _count = 0

      for(_begin <- numbers.indices) {

        // 次の数を_sumに加算しても閾値を上回らなければループする
        while (_end < numbers.length &&
          _sum + numbers(_end) <= _threshold) {
          _sum += numbers(_end)
          _end += 1
        }

      // 加算できている区間の個数が条件を満たす組み合わせの数になる
        _count += _end - _begin

        // _beginが_endを上回った時、_sumが負の値になるので_endは次のループで計算を続行できる
        _sum -= numbers(_begin)
      }
      _count
    }

  def countSumUnder(_threshold: Int): Int = {
    @tailrec
    // TODO loopの名前を変えるべき
    def loop(_begin: Int, _end: Int, _sum: Int, _count: Int): Int = {
      if (_begin < numbers.length) {
        // TODO `_endAndSum`へのアクセスが見にくいのを改善する
        val _endAndSum = calcEndAndSum(_end, _sum)
        loop(_begin + 1, _endAndSum._1, _endAndSum._2 - numbers(_begin), _count + (_endAndSum._1 - _begin))
      }
      else _count
    }

    @tailrec
    def calcEndAndSum(_end: Int, _sum: Int): (Int, Int) = {
      if (_end < numbers.length)
        if (_sum + numbers(_end) <= _threshold)
          calcEndAndSum(_end + 1, _sum + numbers(_end))
        else (_end, _sum)
      else (_end, _sum)
    }

    loop(0, 0, 0, 0)
  }
}
