import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem002EvenFibonacci {

  private static Integer fibonacci(Integer n) {
    return (n < 2)
      ? n
      : fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {
    OptionalInt result = IntStream.range(0, 42)
      .map(Problem002EvenFibonacci::fibonacci)
      .filter(x -> x < 4000000 && x % 2 == 0)
      .reduce(Integer::sum);

    System.out.println("Result: " + result);
  }
}
