import static java.util.stream.IntStream.range;

void main() {
  Function<Integer, Integer> memoizedFibonacci = Memoizer.memoize(Fibonacci::fibonacci);

  OptionalInt result = range(0, 42)
    .map(memoizedFibonacci::apply)
    .filter(x -> x % 2 == 0)
    .takeWhile(x -> x < 4_000_000)
    .reduce(Integer::sum);

  IO.println("Result: " + result);
}
