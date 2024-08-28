import java.util.stream.IntStream;

public class Problem005EvenlyDivisible {

  public static void main(String[] args) {
    Integer n = IntStream.iterate(2520, i -> i + 1)
      .filter(x -> IntStream.rangeClosed(1, 20).allMatch(y -> x % y == 0)).findFirst().orElseThrow();
    System.out.println(n);
  }
}
