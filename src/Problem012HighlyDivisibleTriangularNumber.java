private static long countDivisors(long number) {
  long temp = number;
  long totalDivisors = 1;
  int exponent = 0;

  while ((temp & 1L) == 0L) {
    exponent++;
    temp >>= 1;
  }
  if (exponent > 0) totalDivisors *= (exponent + 1);

  for (long factor = 3; factor * factor <= temp; factor += 2) {
    exponent = 0;
    while (temp % factor == 0) {
      exponent++;
      temp /= factor;
    }
    if (exponent > 0) totalDivisors *= (exponent + 1);
  }

  if (temp > 1) totalDivisors *= 2;

  return totalDivisors;
}

private static long findFirstTriangularWithDivisors(int minimumDivisors) {
  long index = 1;
  long triangular = 1;

  while (countDivisors(triangular) <= minimumDivisors) {
    index++;
    triangular += index;
  }

  return triangular;
}

void main() {
  IO.println(findFirstTriangularWithDivisors(500));
}
