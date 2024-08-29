import static java.util.stream.IntStream.iterate;

public class Problem007NthPrime {

  public static void main(String[] args) {
    int nThPrime = iterate(1, x -> x + 1)
      .filter(PrimeToolKit::isPrime)
      .limit(10001).toArray()[10000];

    //PrimeToolKit.nthPrime(10001);

    System.out.println(nThPrime);
  }
}
