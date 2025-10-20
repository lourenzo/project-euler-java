import kotlin.math.sqrt

private val divisorCache = mutableMapOf<Long, List<Long>>()
private val divisorSumCache = mutableMapOf<Long, Long>()
private val isAbundantCache = mutableMapOf<Long, Boolean>()

fun listDivisors(n: Long): List<Long> {
  if (n <= 1) {
    if (!divisorCache.containsKey(n)) {
      divisorCache[n] = emptyList()
      divisorSumCache[n] = 0L
    }
    return divisorCache.getValue(n)
  }

  if (!divisorCache.containsKey(n)) {
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

    val sortedDivisors = divisors.toList().sorted()
    val sum = divisors.sum()

    divisorCache[n] = sortedDivisors
    divisorSumCache[n] = sum
    divisorSumCache[n]?.let { isAbundantCache[n] = it > n }
  }

  return divisorCache.getValue(n)
}

fun isPerfect(n: Long): Boolean {
  return divisorSumCache[n] == n
}

fun isAbundant(n: Long): Boolean {
  return isAbundantCache[n] == true
}

fun sumCombinativePairs(numbers: List<Long>, limit: Long): List<Long> {
  return numbers.asSequence()
    .flatMap { i ->
      numbers.asSequence()
        .filter { j -> i + j < limit}
        .map { j -> i + j }
    }
    .distinct()
    .sorted()
    .toList()
}

fun main() {
  val limit = 28123L
  for (i in 1L .. limit) {
    val divisors = listDivisors(i)
    //println("$i: isPerfect(${isPerfect(i)}) Divisors: $divisors")
  }
  val abundantNumbersCache = isAbundantCache
    .toList()
    .filter { it -> it.second }.map { it.first }

  //println("abundant numbers: ${abundantNumbersCache.toString()}")

  val sumsOfTwoAbundantNumbers = sumCombinativePairs(abundantNumbersCache, limit)

  val notSumOfTwoAbundantNumbers = mutableListOf(0L)

  var sumOfAllNonSumOfAbundant = 0L

  for (i in 1L .. limit) {
    if (!sumsOfTwoAbundantNumbers.contains(i)) {
      notSumOfTwoAbundantNumbers.add(i)
      sumOfAllNonSumOfAbundant += i
    }
  }

  println("$sumOfAllNonSumOfAbundant")

}
