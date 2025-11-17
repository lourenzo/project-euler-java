private static final Map<Integer, String> numberNames = new HashMap<>() {{
  put(0, "");
  put(1, "one");
  put(2, "two");
  put(3, "three");
  put(4, "four");
  put(5, "five");
  put(6, "six");
  put(7, "seven");
  put(8, "eight");
  put(9, "nine");
  put(10, "ten");
  put(11, "eleven");
  put(12, "twelve");
  put(13, "thirteen");
  put(14, "fourteen");
  put(15, "fifteen");
  put(16, "sixteen");
  put(17, "seventeen");
  put(18, "eighteen");
  put(19, "nineteen");
  put(20, "twenty");
  put(30, "thirty");
  put(40, "forty");
  put(50, "fifty");
  put(60, "sixty");
  put(70, "seventy");
  put(80, "eighty");
  put(90, "ninety");
  put(100, "hundred");
  put(1000, "one thousand");
}};

public static String writeNumber(int n) {
  if (n == 0) return "";
  if (n <= 20 || n == 1000) return numberNames.get(n);
  if (n < 100) {
    int decimalDigit = n / 10;
    int decimalSentence = decimalDigit * 10;
    int unitDigit = n - decimalSentence;
    return numberNames.get(decimalSentence) + (unitDigit > 0 ? "-" : "") + numberNames.get(unitDigit);
  }
  if (n < 1000) {
    int hundredDigit = n / 100;
    int hundredSentence = hundredDigit * 100;
    int decimalPart = n - hundredSentence;
    String hundredText = numberNames.get(hundredDigit) + " hundred";
    return hundredText + (decimalPart > 0 ? " and " : "") + writeNumber(decimalPart);
  }
  throw new IllegalArgumentException("Invalid number");
}

public static int countLetters(String input) {
  String onlyLetters = input.replaceAll("[^A-Za-z]", "");
  return onlyLetters.length();
}

void main() {
  int totalChars = 0;

  for (int i = 1; i <= 1000; i++) {
    String writtenNumber = writeNumber(i);
    int chars = countLetters(writtenNumber);
    totalChars += chars;
    //IO.println("[" + i + "] -> " + writtenNumber + " (" + chars + ")");
  }
  IO.println("Total letters were written: " + totalChars);
}

