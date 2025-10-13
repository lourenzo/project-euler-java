import java.math.BigInteger

fun countLatticePaths(n:Int) : BigInteger {
  val numeratorSize = 2 * n
  val denomonatorSize = n

  return combinations(numeratorSize, denomonatorSize)
}

fun combinations(n: Int, k: Int): BigInteger {
  val actualK = k.coerceAtMost(n - k)
  var result = BigInteger.ONE

  for (i in 0 until actualK) {
    val numerator = BigInteger.valueOf((n - i).toLong())
    val denominator = BigInteger.valueOf((i + 1).toLong())
    result = result.multiply(numerator).divide(denominator)
  }

  return result
}

fun main() {
  val gridSize = 20
  val paths = countLatticePaths(gridSize)

  println("Grid Size: ${gridSize}x${gridSize}")
  println("Total Lattice Paths: $paths")
}
