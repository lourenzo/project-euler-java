import static java.util.stream.IntStream.range;

void main() {
  // TODO: reimplement this from scratch
  Optional<int[]> triplet = range(1, 1000)
    .boxed()
    .flatMap(a -> range(a + 1, 1000 - a)
      .mapToObj(b -> new int[]{a, b, 1000 - a - b})
      .filter(arr -> arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]))
    .findFirst();

  triplet.ifPresent(ints -> IO.println(ints[0] + " " + ints[1] + " " + ints[2]));
}
