void permute(String prefix, String digits, List<String> result) {
  int n = digits.length();

  // Base case: If there are no remaining digits, the prefix is a complete permutation.
  if (n == 0) {
    result.add(prefix);
    return;
  }

  // Recursive step: Try placing each remaining digit in the next position.
  for (int i = 0; i < n; i++) {
    // 1. Choose the current character
    char current = digits.charAt(i);

    // 2. Generate the remaining digits string (remove current char)
    String newDigits = digits.substring(0, i) + digits.substring(i + 1);

    // 3. Recurse with the new prefix and remaining digits
    permute(prefix + current, newDigits, result);
  }
}

List<String> generatePermutations(String digits) {
  List<String> result = new ArrayList<>();
  permute("", digits, result);
  return result;
}

void main(String[] args) {
  String digits = "0123456789";
  List<String> permutations = generatePermutations(digits);
  permutations.sort(String::compareTo);

  System.out.println("Total permutations: " + permutations.size());

  System.out.println("1,000,000 th permutation: " + permutations.get(999_999));

//  for (int i = 0; i < min(1_000_000, permutations.size()); i++) {
//    System.out.println("  " + (i + 1) + ": " + permutations.get(i));
//  }

  System.out.println("\n--- Note for Project Euler Problem 24 ---");
  System.out.println("This recursive method is too slow for 10 digits (0-9).");
  System.out.println("The optimal PE24 solution uses the Factorial Number System to find the Nth permutation directly.");
}
