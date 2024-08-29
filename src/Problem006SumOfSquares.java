import static java.lang.Math.pow;
import static java.util.stream.IntStream.rangeClosed;

public class Problem006SumOfSquares {

  public static void main(String[] args) {
    System.out.println(
      (int) pow(rangeClosed(1, 100).sum(), 2) - rangeClosed(1, 100).map(x -> (int) pow(x, 2)).sum()
    );
  }
}
