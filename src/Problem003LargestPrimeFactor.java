import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.range;

void main() {
  long n = 600851475143L;

  OptionalInt result = range(1, (int) Math.sqrt(n))
    .filter(x -> n % x == 0)
    .filter(number -> number > 1 && range(2, Math.round(Math.sqrt(number))).noneMatch(i -> number % i == 0))
    .takeWhile(x -> x < Math.sqrt(n))
    .reduce((x, y) -> y);

  IO.println(result.orElseThrow());
}
