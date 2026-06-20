import static java.util.stream.IntStream.iterate;

void main() {
  long sum = 1 + iterate(2, step -> step + 2)
    .limit(500)
    .mapToLong(step -> {
      long n = step + 1;
      return 4 * n * n - 6L * step;
    })
    .sum();

  IO.println(sum);
}
