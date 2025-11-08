import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public final class Problem014LongestCollastSequence {
    public static final ConcurrentHashMap<Long, Long> collatzCache = new ConcurrentHashMap<>();

    public static final Function<Long, Long> collatzNext = new Function<Long, Long>() {
        @Override
        public Long apply(Long n) {
            if (n % 2L == 0L) return n / 2L;
            return 3L * n + 1L;
        }
    };

    public static long computeCollatzLengthMemoized(long n, ConcurrentHashMap<Long, Long> cache) {
        if (n == 1L) return 1L;
        Long cached = cache.get(n);
        if (cached != null) return cached;
        long length = 1L + computeCollatzLengthMemoized(collatzNext.apply(n), cache);
        Long prev = cache.putIfAbsent(n, length);
        return prev == null ? length : prev;
    }

    public static long calculateCollatzLengthMemoized(long start, ConcurrentHashMap<Long, Long> cache) {
        if (start <= 0) throw new IllegalArgumentException("Start number must be positive.");
        return computeCollatzLengthMemoized(start, cache);
    }

    public static long calculateCollatzLengthMemoized(long start) {
        return calculateCollatzLengthMemoized(start, collatzCache);
    }

    public static void main(String[] args) {
        long limit = 1_000_000L;
        System.out.println("Finding the starting number under " + limit + " with the longest Collatz chain...");

        long bestStart = 1L;
        long bestLength = 1L;
        for (long i = 1L; i < limit; i++) {
            long len = calculateCollatzLengthMemoized(i);
            if (len > bestLength) {
                bestLength = len;
                bestStart = i;
            }
        }

        System.out.println();
        System.out.println("--- Results ---");
        System.out.println("Starting number: " + bestStart);
        System.out.println("Max sequence length: " + bestLength);
    }
}
