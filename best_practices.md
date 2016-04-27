## Java - Best Practices
I will use this document to list the best practices that I come across while reviewing code online / others code, while learning books / articles, or the hard way by making mistakes.

  - Use Optional wherever possible. so that we can use orElse / orElseThrow
  - If we want to create an empty list and send for some reason for no output, use ImmutableList.of()
  - Use private static functions for code that simply performs extraction and does not depend on any injectable or properties.
  - For Enums,
    - use constructor with caption for better readability.
    - If we need a identify / order, use a private static map to load the data.
  - In JavaDoc use `{ @link }` to refer to custom data model or other classes
  - Use Objects.requireNonNull in place of checkNotNull
  - Use Java 8 streams wherever possible.
  - Try adding Fluent interfaces for the POJOs you create so that we can build the POJOs easily