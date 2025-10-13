val numberNames:Map<Int, String> = mutableMapOf(
  0 to "",
  1 to "one",
  2 to "two",
  3 to "three",
  4 to "four",
  5 to "five",
  6 to "six",
  7 to "seven",
  8 to "eight",
  9 to "nine",
  10 to "ten",
  11 to "eleven",
  12 to "twelve",
  13 to "thirteen",
  14 to "fourteen",
  15 to "fifteen",
  16 to "sixteen",
  17 to "seventeen",
  18 to "eighteen",
  19 to "nineteen",
  20 to "twenty",
  30 to "thirty",
  40 to "forty",
  50 to "fifty",
  60 to "sixty",
  70 to "seventy",
  80 to "eighty",
  90 to "ninety",
  100 to "hundred",
  1000 to "one thousand"
)

fun writeNumber(n: Int): String {
  if (n == 0) return ""
  if (n <= 20 || n == 1000) {
    return numberNames[n]!!
  }

  if (n < 100) {
    val decimalDigit = n / 10;
    val decimalSentence = decimalDigit * 10;
    val unitDigit = n - decimalSentence;

    return "${numberNames[decimalSentence]}${ if (unitDigit > 0) "-" else ""}${numberNames[unitDigit]}"
  }

  if (n < 1000) {
    val hundredDigit = n / 100
    val hundredSentence = hundredDigit * 100
    val decimalPart = n - hundredSentence

    val hundredText = "${numberNames[hundredDigit]} hundred"

    return "$hundredText${if(decimalPart > 0) " and " else ""}${writeNumber(decimalPart)}"
  }

  throw Error("Invalid number")
}

fun countLetters(input: String): Int {
  return Regex("[a-zA-Z]").findAll(input).count()
}

fun main() {
  var totalChars = 0
  (1 until 1001).asSequence()
    .forEach {
      val writtenNumber = writeNumber(it)
      val chars = countLetters(writtenNumber)
      totalChars += chars
      println("[$it] -> ${writtenNumber} (${chars})")
    }
  println("Total letters were written: $totalChars")
}
