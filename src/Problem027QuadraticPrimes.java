import static java.util.Arrays.fill;
import static java.util.Comparator.comparingInt;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

void main() {
  int limitA = 1000; // |a| < 1000
  int limitB = 1000; // |b| <= 1000
  int sieveLimit = 2_100_000; // large enough to cover values produced

  boolean[] isPrime = sieve(sieveLimit);

  // Build the best (a,b,len) using chained stream operations
  Result best = rangeClosed(2, limitB) // candidate b values (must be prime)
    .filter(b -> isPrime[b])
    .boxed()
    .flatMap(b -> range(-limitA + 1, limitA)
      .mapToObj(a -> new Result(a, b, consecutivePrimeLength(a, b, isPrime, sieveLimit))))
    .max(comparingInt(r -> r.len))
    .orElse(new Result(0, 0, 0));

  IO.println(best.a * best.b);
}

// Count how many consecutive n starting from 0 produce primes for n^2 + a*n + b
static int consecutivePrimeLength(int a, int b, boolean[] isPrime, int sieveLimit) {
  int n = 0;
  while (true) {
    long val = (long) n * n + (long) a * n + b;
    if (val <= 0 || val > sieveLimit || !isPrime[(int) val]) break;
    n++;
  }
  return n;
}

static boolean[] sieve(int n) {
  boolean[] isPrime = new boolean[n + 1];
  fill(isPrime, true);

  if (n >= 0) isPrime[0] = false;
  if (n >= 1) isPrime[1] = false;

  for (int p = 2; p * p <= n; p++) {
    if (isPrime[p]) {
      for (int q = p * p; q <= n; q += p) isPrime[q] = false;
    }
  }
  return isPrime;
}

// Small holder for a,b and length to make stream operations readable
record Result(int a, int b, int len) {
}
