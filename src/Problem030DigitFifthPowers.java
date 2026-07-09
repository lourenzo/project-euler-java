import static java.util.stream.IntStream.rangeClosed;

void main() {
  long sum = rangeClosed(2, 354294)
    .filter(n -> String.valueOf(n).chars()
      .map(c -> (int) Math.pow(c - '0', 5))
      .sum() == n)
    .sum();

  IO.println(sum);
}
