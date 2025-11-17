void main() {
  int limit = 10000;

  int[] divisorsSum = new int[limit];

  for (int i = 1; i < limit; i++) {
    int j = i * 2;
    while (j < limit) {
      divisorsSum[j] += i;
      j += i;
    }
  }

  int totalAmicableSum = 0;

  for (int a = 1; a < limit; a++) {
    int b = divisorsSum[a];
    if (b > a && b < limit) {
      if (divisorsSum[b] == a) {
        totalAmicableSum += a;
        totalAmicableSum += b;
      }
    }
  }

  IO.println("Total: " + totalAmicableSum);
}

