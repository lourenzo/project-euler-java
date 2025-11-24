/**
 * @see <a href="https://projecteuler.net/problem=26">Problem 26</a>
 */

public static int getRepeatingCycleLength(int denominator) {
  Map<Integer, Integer> remainderPositions = new HashMap<>();
  int remainder = 1 % denominator;
  int position = 0;

  while (remainder != 0) {
    if (remainderPositions.containsKey(remainder)) {
      return position - remainderPositions.get(remainder);
    }
    remainderPositions.put(remainder, position);
    remainder = (remainder * 10) % denominator;
    position++;
  }

  return 0;
}

void main() {
  int maxLength = 0;
  int result = 1;

  for (int denominator = 2; denominator < 1000; denominator++) {
    int cycleLength = getRepeatingCycleLength(denominator);
    if (cycleLength > maxLength) {
      maxLength = cycleLength;
      result = denominator;
    }
  }

  IO.println("Answer: " + result);
  IO.println("Cycle length: " + maxLength);
}
