import java.math.BigInteger

fun factorial(n: BigInteger): BigInteger {
  return if (n == BigInteger.ZERO) BigInteger.ONE
  else n * factorial(n - BigInteger.ONE)
}

fun main() {
  val factorial = factorial(BigInteger.valueOf(100))

  val sum = factorial.toString()
    .toList()
    .map { c -> c.digitToInt() }
    .reduce { x, y -> x + y }
  println(factorial)
  println(sum)
}
