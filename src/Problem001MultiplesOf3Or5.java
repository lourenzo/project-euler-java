import static java.util.stream.IntStream.range;

void main() {
  OptionalInt result = range(1, 1000)
    .filter(x -> x % 3 == 0 || x % 5 == 0)
    .reduce(Integer::sum);

  IO.println("Result: " + result.orElseThrow());
}
