import java.io.File

fun main() {
  val result = File("./src/0022_names.txt")
    .readText()
    .removePrefix("\"")
    .removeSuffix("\"")
    .splitToSequence("\",\"")
    .sorted()
    .mapIndexed { i: Int, s: String ->
      s.toCharArray()
        .map { it.code - 64 }
        .reduce { a, b -> a + b } * (i + 1)
    }
    .reduce { a, b -> a + b }

  println("Result: $result")
}
