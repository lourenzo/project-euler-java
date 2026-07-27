import java.util.ArrayList;
import java.util.List;
void permute(char[] chars, int index, List<String> result) {
  if (index == chars.length - 1) {
    result.add(new String(chars));
    return;
  }
  for (int i = index; i < chars.length; i++) {
    char temp = chars[i];
    for (int j = i; j > index; j--) {
      chars[j] = chars[j - 1];
    }
    chars[index] = temp;

    permute(chars, index + 1, result);

    temp = chars[index];
    for (int j = index; j < i; j++) {
      chars[j] = chars[j + 1];
    }
    chars[i] = temp;
  }
}

List<String> generatePermutations(String digits) {
  List<String> result = new ArrayList<>();
  if (digits.isEmpty()) {
    result.add("");
    return result;
  }
  permute(digits.toCharArray(), 0, result);
  return result;
}

void main(String[] args) {
  String digits = "0123456789";
  List<String> permutations = generatePermutations(digits);
  permutations.sort(String::compareTo);

  IO.println("Total permutations: " + permutations.size());

  IO.println("1,000,000 th permutation: " + permutations.get(999_999));

//  for (int i = 0; i < min(1_000_000, permutations.size()); i++) {
//    IO.println("  " + (i + 1) + ": " + permutations.get(i));
//  }

  IO.println("\n--- Note for Project Euler Problem 24 ---");
  IO.println("This recursive method is too slow for 10 digits (0-9).");
  IO.println("The optimal PE24 solution uses the Factorial Number System to find the Nth permutation directly.");
}
