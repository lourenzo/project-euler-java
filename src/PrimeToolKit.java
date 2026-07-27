import static java.util.stream.IntStream.iterate;
import static java.util.stream.LongStream.range;

public class PrimeToolKit {

  // From exercise 003
  static boolean isPrime(long number) {
    if (number <= 1) return false;
    long limit = Math.round(Math.sqrt(number));
    for (long i = 2; i <= limit; i++) {
      if (number % i == 0) return false;
    }
    return true;
  }

  // From exercise 007
  static int nthPrime(int n) {
    return iterate(1, x -> x + 1)
      .filter(PrimeToolKit::isPrime)
      .limit(n).toArray()[n - 1];
  }
}
