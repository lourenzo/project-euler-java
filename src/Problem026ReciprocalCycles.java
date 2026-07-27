import java.util.HashMap;
import java.util.Map;

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

void test() {
  assert getRepeatingCycleLength(2) == 0 : "1/2 should not have a repeating cycle";
  assert getRepeatingCycleLength(4) == 0 : "1/4 should not have a repeating cycle";
  assert getRepeatingCycleLength(5) == 0 : "1/5 should not have a repeating cycle";

  assert getRepeatingCycleLength(3) == 1 : "1/3 = 0.(3) -> length 1";
  assert getRepeatingCycleLength(6) == 1 : "1/6 = 0.1(6) -> length 1";
  assert getRepeatingCycleLength(7) == 6 : "1/7 = 0.(142857) -> length 6";
  assert getRepeatingCycleLength(9) == 1 : "1/9 = 0.(1) -> length 1";
}

void main() {
  test();

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
