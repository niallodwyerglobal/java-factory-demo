# Coding standards

The review agent cites these by heading. Keep each rule checkable.

## Money is never a double

Amounts are `Money`, backed by `BigDecimal` at two decimal places. No
`double` or `float` anywhere near a price. Every rounding names its
`RoundingMode` explicitly.

## Immutable by default

Value types are records. Classes that hold collections copy them in and hand
out unmodifiable views. A change to a basket returns a new basket.

## Validate at construction

A record's compact constructor rejects invalid state with
`IllegalArgumentException` or `NullPointerException`, naming the bad field.
Nothing downstream re-checks.

## Small public surface

Only what a caller needs is `public`. Constants and helpers default to
package-private. A new public type or method needs a Javadoc sentence saying
what it is for.

## Final parameters and locals

Method parameters and local variables are `final`.

## Tests describe behaviour

Every behaviour change ships with a test that would fail without it. Test
names are sentences about behaviour (`addsVatAtTwentyPercentToTheSubtotal`).
Tests go through the public API. Use `@ParameterizedTest` for a table of
cases. No mocks of this library's own classes.

## No new dependencies without saying so

A new dependency in `build.gradle` is called out at the top of the pull
request with the reason.
