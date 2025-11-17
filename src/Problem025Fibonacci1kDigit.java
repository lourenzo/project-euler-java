void main() {
  int targetDigits = 1000;
  BigInteger a = BigInteger.ZERO;
  BigInteger b = BigInteger.ONE;
  int i = 1;

  while (b.toString().length() < targetDigits) {
    BigInteger temp = a.add(b);
    a = b;
    b = temp;
    i++;
  }

  IO.println("Index: " + i);
  IO.println("Digits: " + b.toString().length());
}
