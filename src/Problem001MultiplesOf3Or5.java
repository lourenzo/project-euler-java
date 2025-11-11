void main() {
  OptionalInt result = IntStream
    .range(1, 1000)
    .filter(x -> x % 3 == 0 || x % 5 == 0)
    .reduce(Integer::sum);

  IO.println("Result: " + result.orElseThrow());
}
