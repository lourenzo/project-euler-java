import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Problem004PalindromicNumber {

  public static boolean isPalindrome(int number) {
    String stringNum = String.valueOf(number);
    String reverseStringNum = new StringBuilder(stringNum).reverse().toString();

    return stringNum.equals(reverseStringNum);
  }

  public static List<Integer> progressiveIterationResults() {
    return IntStream.range(100, 1000)
      .mapToObj(x -> IntStream.range(100, 1000)
        .map(y -> x * y)
        .distinct()
        .filter(Problem004PalindromicNumber::isPalindrome)
        .boxed())
      .flatMap(stream -> stream)
      .sorted()
      .distinct()
      .toList();
  }

  public static Optional<Integer> progressiveOptimized() {
    return IntStream.range(900, 999)
      .mapToObj(x -> IntStream.range(900, 999)
        .map(y -> x * y)
        .distinct()
        .filter(Problem004PalindromicNumber::isPalindrome)
        .boxed())
      .flatMap(stream -> stream)
      .max(Integer::compareTo);
  }

  public static void main(String[] args) {
    List<Integer> nums = progressiveIterationResults();
    System.out.println("Normal: " + nums);
    Optional<Integer> num = progressiveOptimized();
    System.out.println("Optimized: " + num);
  }

  // Improvements: make the range descending, from 999 to 900 is enough

}
