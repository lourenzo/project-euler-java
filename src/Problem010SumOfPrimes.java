void main() {
  int limit = 2_000_000;
  boolean[] sieve = new boolean[limit];
  int r = (int) Math.sqrt(limit);

  IntStream.rangeClosed(2, r).filter(i -> !sieve[i]).forEach(i -> {
    for (int j = i * i; j < limit; j += i) sieve[j] = true;
  });
  long result = IntStream.range(2, limit).filter(i -> !sieve[i]).asLongStream().sum();

  IO.println("Result: " + result);
}

