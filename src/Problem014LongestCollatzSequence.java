public static final ConcurrentHashMap<Long, Long> collatzCache = new ConcurrentHashMap<>();

public static final Function<Long, Long> collatzNext = n ->
  (n % 2L == 0L)
    ? n / 2L
    : 3L * n + 1L;


public static long memoizedLength(long n, ConcurrentHashMap<Long, Long> cache) {
  if (n == 1L) return 1L;
  Long cached = cache.get(n);
  if (cached != null) return cached;
  long length = 1L + memoizedLength(collatzNext.apply(n), cache);
  Long prev = cache.putIfAbsent(n, length);
  return prev == null ? length : prev;
}

public static long calculateCollatzLength(long start, ConcurrentHashMap<Long, Long> cache) {
  if (start <= 0) throw new IllegalArgumentException("Start number must be positive.");
  return memoizedLength(start, cache);
}

public static long calculateCollatzLength(long start) {
  return calculateCollatzLength(start, collatzCache);
}

void main() {
  long limit = 1_000_000L;
  IO.println("Finding the starting number under " + limit + " with the longest Collatz chain...");

  long bestStart = 1L;
  long bestLength = 1L;
  for (long i = 1L; i < limit; i++) {
    long len = calculateCollatzLength(i);
    if (len > bestLength) {
      bestLength = len;
      bestStart = i;
    }
  }

  IO.println("--- Results ---");
  IO.println("Starting number: " + bestStart);
  IO.println("Max sequence length: " + bestLength);
}
