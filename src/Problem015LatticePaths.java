public static BigInteger combinations(int k) {
  int n = 2 * k;
  int actualK = Math.min(k, n - k);
  BigInteger result = BigInteger.ONE;
  for (int i = 0; i < actualK; i++) {
    BigInteger numerator = BigInteger.valueOf(n - i);
    BigInteger denominator = BigInteger.valueOf(i + 1);
    result = result.multiply(numerator).divide(denominator);
  }
  return result;
}

void main() {
  int gridSize = 20;
  BigInteger paths = combinations(gridSize);
  IO.println("Grid Size: " + gridSize + "x" + gridSize);
  IO.println("Total Lattice Paths: " + paths);
}

