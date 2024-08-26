import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem003LargestPrimeFactor {

  private static boolean isPrime(long number) {
    return number > 1 && LongStream.range(2, number).noneMatch(i -> number % i == 0);
  }

  public static void main(String[] args) {
    long n = 600851475143L;

    IntStream.range(1, (int) Math.sqrt(n))
      .filter(x -> n % x == 0)
      .filter(Problem003LargestPrimeFactor::isPrime)
      .filter(x -> x < Math.sqrt(n))
      .forEach(
        x -> {
          System.out.printf("%d %b%n", x, isPrime(x));
        }
      );

    //List<Long> primesUntil = primeNumbersUntil(n);
    //System.out.println(primesUntil.get(primesUntil.size() - 1));
  }
}
