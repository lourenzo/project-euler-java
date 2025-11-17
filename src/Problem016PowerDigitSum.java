void main() {
  String bigNumber = BigInteger.valueOf(2).pow(1000).toString();
  int digitsSum = 0;

  for (char digit : bigNumber.toCharArray()) {
    digitsSum += digit - '0';
  }

  IO.println("Digits Sum: " + digitsSum);
}
