# Context Recovery

This project is a collection of Java scripts for Project Euler solutions, employing modern Java features and a functional programming approach.

## Problems Solved
Currently, problems **1 through 42** are implemented.

## Utilities
- `PrimeToolKit`: Contains methods for primality checks and sequence generation.
- `Memoizer`: A generic cache class designed to memorize recursive function results (used effectively in Collatz sequences).

## Adding New Solutions
When adding a new solution:
1. Create a file `ProblemXXX[Name].java` in the `src/` directory.
2. Use Unnamed Classes (`void main()`).
3. Leverage the Stream API for data manipulation and iteration com **Static Imports**.
4. Sempre utilize `IO.println` para saídas, em vez de `System.out.println`.
5. If a generic tool logic emerges, extract it to a utility file.
