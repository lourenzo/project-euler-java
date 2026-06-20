# Project Euler Java Solutions - Specifications

## Technology Stack
- Java 21+

## Coding Paradigms
- **Unnamed Classes & Instance Main Methods (JEP 445/463)**: Code should be written as simple scripts without outer class declarations. Use `void main()`.
- **Functional Programming First**: Prefer `java.util.stream` (e.g., `IntStream`, `Stream`) over imperative loops (`for`, `while`) to maximize expressiveness and readability.
- **Data Structures**: Use `record` for immutable tuples/data carriers.
- **IO Output**: Sempre utilizar `IO.println` e `IO.print` no lugar das versões legadas de `System.out.*`.
- **Static Imports**: Para a API de `java.util.stream` e `java.util.Arrays` (ex: `IntStream.range`, `Arrays.stream`), SEMPRE utilizar *static imports* no topo do arquivo para simplificar a sintaxe ao máximo.
- **Optimization Philosophy**: 
  - Expressiveness comes first. 
  - Algorithmic performance (e.g., Sieve of Eratosthenes, mathematically reduced formulas) comes second. 
  - Avoid sacrificing pure Streams for imperative arrays just to save milliseconds, unless strictly necessary for a significant bottleneck.
