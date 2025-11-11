import static java.lang.Math.pow;
import static java.util.stream.IntStream.rangeClosed;

void main() {
  IO.println(
    (int) pow(rangeClosed(1, 100).sum(), 2) - rangeClosed(1, 100).map(x -> (int) pow(x, 2)).sum()
  );
}
