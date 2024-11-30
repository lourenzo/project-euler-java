import java.util.Optional;

import static java.util.stream.IntStream.iterate;

public class Problem004PalindromicNumber {

  public static boolean isPalindrome(int number) {
    return String
      .valueOf(number)
      .equals(new StringBuilder(String.valueOf(number)).reverse().toString());
  }

  public static void main(String[] args) {
    Optional<Integer> num = iterate(999, x -> x > 900, x -> x - 1)
      .mapToObj(x -> iterate(999, y -> y > 900, y -> y - 1)
        .map(y -> x * y)
        .distinct()
        .filter(Problem004PalindromicNumber::isPalindrome)
        .boxed())
      .flatMap(stream -> stream)
      .max(Integer::compareTo);

    System.out.println(num);
  }

  // Improvements: make the range descending, from 999 to 900 is enough
}
