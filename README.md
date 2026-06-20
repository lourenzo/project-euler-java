# Project Euler - Java Streams

My implementations of solutions for the problems in Project Euler, as I am
coding it along.

## Development Process & Reflections

This repository contains my personal solutions for the **Project Euler** challenges. My primary goal here is to explore modern Java features and adopt a functional programming style. I'm aiming for code that is elegant, concise, and expressive, though I recognize there is always room for optimization.

### What I'm Focusing On (and Proud Of)

- **Modern Java Capabilities**: I'm making extensive use of recent Java features, such as *Unnamed Classes* and *Instance Main Methods* (`void main()`), as well as `Records` for immutable data. This keeps the boilerplate to a minimum.
- **Functional Programming & Streams**: I heavily favor the `Stream` API (`IntStream`, etc.) and **Static Imports** to keep the code declarative and readable. Sometimes this comes at a slight performance cost compared to imperative arrays, but expressiveness is my priority.
- **Reusability**: As I progress, I'm extracting common logic into generic utilities, like the `PrimeToolKit` for primes and a `Memoizer` for caching recursive results.
- **Algorithmic Efficiency**: I try my best to avoid pure brute force, favoring approaches like the Sieve of Eratosthenes or prime factorization to achieve better algorithmic complexity.

### Room for Improvement

While I'm happy with how clean the codebase is, I know there are compromises:
- **The Cost of Elegance**: My caching strategy relies on wrappers (like `Long`). It's elegant and reusable, but I recognize that the constant boxing/unboxing overhead makes it slower than using primitive arrays if raw performance is the only goal.
- **Awareness of Bottlenecks**: In some problems, I've used recursive generators that allocate all possibilities in memory. I'm aware of more optimal mathematical approaches (like the Factorial Number System) and I leave notes for myself to refactor these bottlenecks in the future.
- **Matrix Traversals**: Matrix checks could be abstracted better with directional arrays (`dx`/`dy`) to avoid repetitive `if` statements, but for now, I value the straightforwardness of the current implementation.

Ultimately, this project is a learning journey—a balance between writing beautifully modern Java and solving complex mathematical problems efficiently.

## To-Do

- [x] Build a stream-efficient Prime number detection library
- [ ] Add a time efficiency calculating library
