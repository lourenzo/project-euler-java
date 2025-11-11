void main() {
  Function<Integer, Integer> memoizedFibonacci = Memoizer.memoize(Fibonacci::fibonacci);

  OptionalInt result = IntStream.range(0, 42)
    .map(memoizedFibonacci::apply)
    .filter(x -> x % 2 == 0)
    .takeWhile(x -> x < 4_000_000)
    .reduce(Integer::sum);

  IO.println("Result: " + result);
}
