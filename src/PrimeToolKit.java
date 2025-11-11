import static java.util.stream.IntStream.iterate;
import static java.util.stream.LongStream.range;

public class PrimeToolKit {

  // From exercise 003
  static boolean isPrime(long number) {
    return number > 1 && range(2, Math.round(Math.sqrt(number))).noneMatch(i -> number % i == 0);
  }

  // From exercise 007
  static int nthPrime(int n) {
    return iterate(1, x -> x + 1)
        .filter(PrimeToolKit::isPrime)
        .limit(n).toArray()[n - 1];
  }
}
