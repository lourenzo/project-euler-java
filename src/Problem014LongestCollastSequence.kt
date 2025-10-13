import java.util.concurrent.ConcurrentHashMap

val collatzCache = ConcurrentHashMap<Long, Long>()

val collatzNext: (Long) -> Long = { n -> if (n % 2L == 0L) n / 2 else 3 * n + 1 }

fun computeCollatzLengthMemoized(n: Long, cache: ConcurrentHashMap<Long, Long> = collatzCache): Long {
    if (n == 1L) return 1L
    cache[n]?.let { return it }
    val length = 1 + computeCollatzLengthMemoized(collatzNext(n), cache)
    val prev = cache.putIfAbsent(n, length)
    return prev ?: length
}

fun calculateCollatzLengthMemoized(start: Long, cache: ConcurrentHashMap<Long, Long> = collatzCache): Long {
    require(start > 0) { "Start number must be positive." }
    return computeCollatzLengthMemoized(start, cache)
}

fun main() {
    val limit = 1_000_000L
    println("Finding the starting number under $limit with the longest Collatz chain...")

    val result = (1L until limit).asSequence()
        .map { it to calculateCollatzLengthMemoized(it) }
        .maxByOrNull { it.second }

    val (longestChainStart, maxLength) = result ?: (1L to 1L)

    println("\n--- Results ---")
    println("Starting number: $longestChainStart")
    println("Max sequence length: $maxLength")
}
