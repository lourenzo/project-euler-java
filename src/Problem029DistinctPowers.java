import static java.util.stream.IntStream.rangeClosed;

void main() {
  long count = rangeClosed(2, 100)
    .mapToObj(BigInteger::valueOf)
    .flatMap(a -> rangeClosed(2, 100).mapToObj(a::pow))
    .distinct()
    .count();

  IO.println(count);
}
