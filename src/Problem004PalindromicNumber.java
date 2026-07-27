import static java.util.stream.IntStream.iterate;

void main() {
  Optional<Integer> num = iterate(999, x -> x > 900, x -> x - 1)
    .mapToObj(x -> iterate(999, y -> y > 900, y -> y - 1)
      .map(y -> x * y)
      .distinct()
      .filter((int number) -> {
        int original = number;
        int reversed = 0;
        while (number > 0) {
          reversed = reversed * 10 + number % 10;
          number /= 10;
        }
        return original == reversed;
      })
      .boxed())
    .flatMap(stream -> stream)
    .max(Integer::compareTo);

  IO.println(num.orElseThrow());
}
