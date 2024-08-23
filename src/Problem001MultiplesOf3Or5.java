import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Problem001MultiplesOf3Or5 {
  public static void main(String[] args) {
    OptionalInt result = IntStream
        .range(1, 1000)
        .filter(x -> x % 3 == 0 || x % 5 == 0)
        .reduce(Integer::sum);

    System.out.println("Result: " + result);
  }
}
