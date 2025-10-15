fun main() {
  val limit = 10000
  val divisorsSum = IntArray(limit) { 0 }

  for (i in 1 until limit) {
    var j = 2 * i

    while (j < limit) {
      divisorsSum[j] += i
      j += i
    }
  }

  var totalAmicableSum = 0

  for (a in 1 until limit) {
    val b = divisorsSum[a]

    if (b in (a + 1)..<limit) {
      if (divisorsSum[b] == a) {
        totalAmicableSum += a
        totalAmicableSum += b
      }
    }
  }

  println("Total: $totalAmicableSum")
}
