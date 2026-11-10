# java-factory-demo

A small basket-pricing library: `Basket`, `LineItem`, `Money`, and
`PriceCalculator`, which turns a basket into a `Quote` (subtotal, VAT,
total). Java 21, Gradle, JUnit 5 and AssertJ.

## Verification

Run this before you report a change as complete, and before every commit:

```bash
./gradlew check
```

It compiles with `-Xlint:all -Werror` and runs the tests. The pre-commit hook
in `.githooks/pre-commit` runs the same command.

## Layout

- `src/main/java/com/example/basket/` — the library. One public type per file.
- `src/test/java/com/example/basket/` — tests, one test class per class under
  test, named `<Class>Test`.

## Words

- **Basket** — the immutable list of line items being bought.
- **Line item** — one SKU at a unit price and a quantity.
- **Quote** — what a basket costs: subtotal, VAT, total.
- **Money** — pounds sterling, held to the penny as a `BigDecimal`.

## Rules

Follow [CODING_STANDARDS.md](CODING_STANDARDS.md). The review agent checks
every change against it.

## Agent factory

Labels on issues and pull requests start agents from
`niallodwyerglobal/agent-factory`; see `.github/workflows/agents.yml`.
`agent:explore` posts findings, `agent:implement` opens a draft PR,
`agent:review` reviews one.
