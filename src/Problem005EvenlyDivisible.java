import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

void main() {
  Integer n = iterate(2520, i -> i + 20)
    .filter(x -> rangeClosed(1, 20).allMatch(y -> x % y == 0))
    .findFirst().orElseThrow();

  IO.println(n);
}
