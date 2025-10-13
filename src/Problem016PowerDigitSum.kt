import java.math.BigInteger

fun main() {
  val bigNumber = BigInteger.valueOf(2).pow(1000)
  val digitsSum = bigNumber.toString()
    .map { it.toString().toInt() }
    .reduce { acc, i -> acc + i }

  println("Digits Sum: $digitsSum")
}
