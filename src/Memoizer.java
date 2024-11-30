import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Memoizer<T, R> {
  private final ConcurrentHashMap<T, R> cache = new ConcurrentHashMap<>();

  private Memoizer() {}

  public static <T, R> Function<T, R> memoize(Function<T, R> function) {
    Memoizer<T, R> memoizer = new Memoizer<>();
    return input -> memoizer.cache.computeIfAbsent(input, function);
  }
}
