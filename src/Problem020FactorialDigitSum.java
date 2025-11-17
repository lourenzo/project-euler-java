public static BigInteger factorial(int n) {
  BigInteger result = BigInteger.ONE;

  for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));

  return result;
}

void main() {
  String factorial = factorial(100).toString();
  int sum = 0;

  for (char c : factorial.toCharArray()) sum += c - '0';

  IO.println(factorial);
  IO.println(sum);
}

