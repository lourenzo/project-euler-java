import kotlin.math.sqrt

private val isAbundantCache = mutableMapOf<Long, Boolean>()

fun buildCacheFor(n: Long) {
    val divisors = mutableSetOf(1L)
    val limit = sqrt(n.toDouble()).toLong()

    for (i in 2L..limit) {
      if (n % i == 0L) {
        divisors.add(i)
        val complement = n / i
        if (complement != i) {
          divisors.add(complement)
        }
      }
    }

    isAbundantCache[n] = divisors.sum() > n
}

fun sumCombinativePairs(numbers: List<Long>, limit: Long): List<Long> {
  return numbers.asSequence()
    .flatMap { i ->
      numbers.asSequence()
        .filter { j -> i + j <= limit}
        .map { j -> i + j }
    }
    .distinct()
    .sorted()
    .toList()
}

fun main() {
  val limit = 28123L

  for (n in 1L .. limit) {
    buildCacheFor(n)
  }

  val abundantNumber = isAbundantCache
    .toList()
    .filter { it -> it.second }
    .map { it.first }

  val sumsOfTwoAbundantNumbers = sumCombinativePairs(abundantNumber, limit)
  var sumOfAllNonSumOfAbundant = 0L

  for (n in 1L .. limit) {
    if (!sumsOfTwoAbundantNumbers.contains(n)) {
      sumOfAllNonSumOfAbundant += n
    }
  }

  println("$sumOfAllNonSumOfAbundant")
}
