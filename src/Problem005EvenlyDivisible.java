import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

public class Problem005EvenlyDivisible {

  public static void main(String[] args) {
    Integer n = iterate(2520, i -> i + 1)
      .filter(x -> rangeClosed(1, 20).allMatch(y -> x % y == 0))
      .findFirst().orElseThrow();

    System.out.println(n);
  }
}
