import java.util.HashSet;
import java.util.Map;

import static java.lang.Math.sqrt;

import java.util.stream.Collectors;


void buildCacheFor(long n, Map<Long, Boolean> isAbundantCache) {
  if (n == 0) return;

  var divisors = new HashSet<Long>();
  divisors.add(1L);
  long limit = (long) sqrt(n);

  for (long i = 2; i <= limit; i++) {
    if (n % i == 0) {
      divisors.add(i);
      var complement = n / i;
      if (complement != i) {
        divisors.add(complement);
      }
    }
  }

  long sum = 0;
  for (long divisor : divisors) {
    sum += divisor;
  }

  isAbundantCache.put(n, sum > n);
}

void main() {
  final long LIMIT = 28123L;
  var isAbundantCache = new java.util.HashMap<Long, Boolean>();

  for (long n = 1; n <= LIMIT; n++) {
    buildCacheFor(n, isAbundantCache);
  }

  var abundantNumbers = isAbundantCache.entrySet().stream()
    .filter(Map.Entry::getValue)
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());

  var abundantSumsSet = new HashSet<Long>();

  for (int i = 0; i < abundantNumbers.size(); i++) {
    var a = abundantNumbers.get(i);
    for (int j = i; j < abundantNumbers.size(); j++) {
      var b = abundantNumbers.get(j);
      var sum = a + b;

      if (sum <= LIMIT) {
        abundantSumsSet.add(sum);
      } else {
      }
    }
  }

  long sumOfAllNonSumOfAbundant = 0L;
  for (long n = 1; n <= LIMIT; n++) {
    if (!abundantSumsSet.contains(n)) {
      sumOfAllNonSumOfAbundant += n;
    }
  }

  System.out.println(sumOfAllNonSumOfAbundant);
}
