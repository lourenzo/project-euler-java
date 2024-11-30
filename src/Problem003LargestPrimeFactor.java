import java.util.OptionalInt;

import static java.util.stream.IntStream.range;
import static java.util.stream.LongStream.range;

public class Problem003LargestPrimeFactor {

  private static boolean isPrime(long number) {
    return number > 1 && range(2, Math.round(Math.sqrt(number))).noneMatch(i -> number % i == 0);
  }

  public static void main(String[] args) {
    long n = 600851475143L;

    OptionalInt result = range(1, (int) Math.sqrt(n))
      .filter(x -> n % x == 0)
      .filter(Problem003LargestPrimeFactor::isPrime)
      .takeWhile(x -> x < Math.sqrt(n))
      .reduce((x, y) -> y);

    System.out.println(result);

    //List<Long> primesUntil = primeNumbersUntil(n);
    //System.out.println(primesUntil.get(primesUntil.size() - 1));
  }
}
