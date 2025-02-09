# Scala For-Comprehension Future Bug

This repository demonstrates a subtle bug related to using for-comprehensions with Futures in Scala. The code appears correct at first glance, but it has a runtime issue stemming from an unexpected return type within the for-comprehension.

## Bug Description

The core issue lies in the `for` comprehension, which incorrectly handles the return values of the Futures.  The `yield` statement doesn't return a value as expected, leading to unexpected behavior.  The example demonstrates how the issue can lead to runtime exceptions or incorrect results.

## Solution

The solution corrects the `for` comprehension to explicitly return the desired values, ensuring the `combinedFuture` correctly processes the outputs of `future1` and `future2`.