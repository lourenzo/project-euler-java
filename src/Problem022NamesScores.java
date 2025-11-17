void main() throws IOException {
  // file downloaded from: https://projecteuler.net/resources/documents/0022_names.txt
  String content = Files.readString(Paths.get("src/0022_names.txt"));

  if (content.startsWith("\"") && content.endsWith("\"")) {
    content = content.substring(1, content.length() - 1);
  }

  String[] names = content.split("\",\"");
  Arrays.sort(names);

  long total = 0L;

  for (int i = 0; i < names.length; i++) {
    String name = names[i];
    int current = 0;
    for (char letter : name.toCharArray()) {
      current += (letter - 'A') + 1;
    }
    total += (long) current * (i + 1);
  }

  IO.println("Result: " + total);
}


