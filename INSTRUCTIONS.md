# Questioner Question Writing Instructions

This document provides a comprehensive step-by-step guide for writing questions using the Questioner framework.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Question Types](#question-types)
3. [Step-by-Step: Writing a Basic Method Question](#step-by-step-writing-a-basic-method-question)
4. [Step-by-Step: Writing a Class Question](#step-by-step-writing-a-class-question)
5. [Step-by-Step: Writing a Snippet Question](#step-by-step-writing-a-snippet-question)
6. [Advanced Features](#advanced-features)
7. [Validation and Testing](#validation-and-testing)
8. [Common Errors and Solutions](#common-errors-and-solutions)
9. [Best Practices](#best-practices)

## Prerequisites

- Java 17 installed (use `asdf` for version management)
- IntelliJ IDEA (recommended) or another Java IDE
- Gradle (included via gradlew wrapper)
- Basic understanding of Java and/or Kotlin

## Question Types

Questioner supports three main question types:

1. **Method Questions**: Students implement a single method
2. **Class Questions**: Students implement an entire class
3. **Snippet Questions**: Students complete a code snippet (templated)

## Step-by-Step: Writing a Basic Method Question

### 1. Create Directory Structure

Create a directory under `src/main/java/<your-package>/`:

```
src/main/java/edu/illinois/cs/cs124/questioner/yournetid/questionname/
```

**Important**: Do NOT use the `com.examples` package as it's ignored during upload.

### 2. Create the Question File

Create `Question.java` in your question directory:

```java
package edu.illinois.cs.cs124.questioner.yournetid.questionname;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;

/*
 * Write a method `addOne` that returns its `int` argument plus one.
 */

@Correct(
    name = "Add One",
    author = "yournetid@illinois.edu",
    version = "2025.11.0"
)
@Wrap
public class Question {
  int addOne(int value) {
    return value + 1;
  }
}
```

### 3. Key Components Explained

#### Problem Description Comment
The comment block above the class is converted to the problem description shown to students:
```java
/*
 * Write a method `addOne` that returns its `int` argument plus one.
 */
```
- Use Markdown formatting
- Wrap code in backticks: `methodName`
- Be clear and specific

#### @Correct Annotation
Required metadata for the question:
```java
@Correct(
    name = "Add One",              // Display name
    author = "yournetid@illinois.edu",  // Your email
    version = "2025.11.0"          // Use date-based versioning: YYYY.M.MINOR
)
```

**Version Format**: `YYYY.M.MINOR`
- `YYYY` = current year
- `M` = current month (no leading zero)
- `MINOR` = minor version (0 for new month/year, increment within month)

#### @Wrap Annotation
Use `@Wrap` for method-only problems. This tells Questioner to:
- Extract just the method for students to implement
- Create a template that wraps the student's code
- Test the method in isolation

### 4. Validate Your Question

Run validation using Gradle:

```bash
./gradlew collectQuestions
```

Or use IntelliJ run configuration: **"Test All"**

This generates:
- `.question.json` - Validated question metadata
- `report.html` - Detailed validation report

### 5. Review Validation Output

Check the generated files:
- `.question.json` - Confirms successful validation
- `report.html` - Shows mutation testing results

Open `report.html` in a browser to see:
- Which mutations were caught
- Test coverage statistics
- Generated test inputs

## Step-by-Step: Writing a Class Question

### 1. Create Directory Structure

Same as method questions:
```
src/main/java/edu/illinois/cs/cs124/questioner/yournetid/counterobject/
```

### 2. Create the Class File

**Important**: For class questions, the file name should match the class name (not `Question.java`):

```java
package edu.illinois.cs.cs124.questioner.yournetid.counterobject;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Define and implement a `public` class `Counter`.
 * `Counter` should provide a single public constructor that accepts an `int` parameter.
 * It should also provide `increment` and `decrement` methods, both taking no parameters and
 * returning `void`.
 * `increment` should increase the stored count, while `decrement` should decrease it.
 * Finally, provide a `getValue` method that returns the stored value.
 */

@Correct(name = "Counter", author = "yournetid@illinois.edu", version = "2025.11.0")
public class Counter {
  private int value;

  public Counter(int setValue) {
    value = setValue;
  }

  public void increment() {
    value++;
  }

  public void decrement() {
    value--;
  }

  public int getValue() {
    return value;
  }
}
```

### 3. Key Differences from Method Questions

- **No @Wrap annotation** - The entire class is the question
- **File name matches class name** - Use `Counter.java`, not `Question.java`
- **Must provide verification** - Questioner needs a way to verify generated instances

### 4. The "No Way to Verify Generated Receivers" Error

For class questions, Questioner needs:
1. A way to **create instances** (constructor)
2. A way to **verify instances** (getter methods)

If you see this error, add a getter method:

```java
// ❌ BAD - No way to verify
public class Dog {
  private String name;
  public Dog(String setName) { name = setName; }
}

// ✅ GOOD - Can verify via getName()
public class Dog {
  private String name;
  public Dog(String setName) { name = setName; }
  public String getName() { return name; }
}
```

## Step-by-Step: Writing a Snippet Question

### 1. Use TEMPLATE_START and TEMPLATE_END

Mark the code students should complete:

```java
package edu.illinois.cs.cs124.questioner.yournetid.printsum;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Given two `int` variables `first` and `second` that are already declared and initialized,
 * print their sum.
 */

@Correct(name = "Print Sum", author = "yournetid@illinois.edu", version = "2025.11.0")
public class Question {
  public static void printSum(int first, int second) {
    // TEMPLATE_START
    System.out.println(first + second);
    // TEMPLATE_END
  }
}
```

### 2. Important Notes for Snippets

- **Mark method as `static`** - Avoids "no way to verify generated receivers" error
- Use `void` return type for printing questions
- Everything between `TEMPLATE_START` and `TEMPLATE_END` is extracted for students

## Advanced Features

### Custom Test Inputs with @FixedParameters

Provide specific test cases:

```java
import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import java.util.Arrays;
import java.util.List;

@FixedParameters
private static final List<Integer> FIXED = Arrays.asList(88, 188, 888, 8);
```

**For multiple parameters**, use `Two`, `Three`, etc.:

```java
import edu.illinois.cs.cs125.jenisol.core.Two;

@FixedParameters
private static final List<Two<String, String>> FIXED =
    Arrays.asList(new Two<>("Java", "Kotlin"), new Two<>("CS125", "CS124"));
```

### Random Input Generation with @RandomParameters

Generate random test inputs:

```java
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import java.util.Random;

@RandomParameters
private static int randomInts(Random random) {
  if (random.nextBoolean()) {
    return 88;
  } else {
    return random.nextInt();
  }
}
```

**For multiple parameters**, return `Two`, `Three`, etc.:

```java
@RandomParameters
private static Two<String, String> randomStrings(Random random) {
  String first = Generators.randomAlphanumericStringWithLength(random, random.nextInt(32) + 2);
  String second = Generators.randomAlphanumericStringWithLength(random, random.nextInt(32) + 2);
  return new Two<>(first, second);
}
```

### Mutation Suppression

Sometimes mutations create code that's still correct. Suppress specific mutations:

```java
int larger(int first, int second) {
  if (first > second) { // mutate-disable-conditional-boundary
    return first;
  } else {
    return second;
  }
}
```

**Common suppressions**:
- `mutate-disable-conditional-boundary` - Prevents `>` to `>=` mutations
- `mutate-disable-modify-length-and-size` - Prevents length/size modifications
- `mutate-disable-string-literal` - Prevents string literal changes
- `mutate-disable-string-literal-trim` - Prevents string trimming

### Handling Exceptions

For questions requiring exception handling:

```java
public static long factorial(long input) {
  if (input <= 0) { // mutate-disable-conditional-boundary
    throw new IllegalArgumentException();
  }
  if (input == 1) {
    return 1;
  }
  return input * factorial(input - 1);
}
```

### Manually Annotated Incorrect Examples

Create common mistakes you want to ensure are caught:

**Directory structure**:
```
questionname/
├── Question.java
└── incorrect/
    └── badimplementation/
        └── Question.java
```

**Incorrect example**:
```java
package edu.illinois.cs.cs124.questioner.yournetid.questionname.incorrect.badimplementation;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect
public class Question {
  int addOne(int value) {
    return value + 11;  // Common mistake
  }
}
```

### Adding Kotlin Support

Create a Kotlin alternative under `correct/kotlin/`:

**Directory structure**:
```
questionname/
├── Question.java
└── correct/
    └── kotlin/
        └── Question.kt
```

**Kotlin solution**:
```kotlin
package edu.illinois.cs.cs124.questioner.yournetid.questionname.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

@AlsoCorrect
class Question {
  fun addOne(value: Int): Int {
    return value + 1
  }
}
```

### @Correct Annotation Options

Additional options for fine-tuning:

```java
@Correct(
    name = "Question Name",
    author = "yournetid@illinois.edu",
    version = "2025.11.0",
    maxLineCountMultiplier = 16,    // Allow submissions up to 16x reference length
    maxDeadCode = 2,                 // Allow up to 2 dead code instances
    maxComplexity = 10               // Maximum cyclomatic complexity
)
```

## Validation and Testing

### Running Validation

**Option 1: Gradle Command Line**

```bash
# Validate all questions
./gradlew collectQuestions

# Clean and revalidate
./gradlew cleanQuestions collectQuestions

# Run tests
./gradlew test
```

**Option 2: IntelliJ Run Configurations**

- **Test All** - Validate and test all questions
- **Test Focused** - Test questions you're actively working on
- **Test Unvalidated** - Test questions without .question.json
- **Clean All** - Remove all validation artifacts
- **Check** - Run checks without full validation
- **Publish** - Publish questions to configured endpoint

### Understanding Validation Output

#### .question.json
Contains validated question metadata:
- Content hash
- Question type (METHOD/CLASS/SNIPPET)
- Supported languages
- Generated descriptions
- Feature analysis

#### report.html
Interactive HTML report showing:
- **Mutation Testing Results** - Which mutations were caught/missed
- **Test Coverage** - Input coverage statistics
- **Performance Metrics** - Execution times
- **Complexity Analysis** - Code complexity measures

### Focused Testing During Development

Add this to mark a question as "focused" during development:

```java
@Correct(
    name = "My Question",
    author = "yournetid@illinois.edu",
    version = "2025.11.0",
    focused = true  // Only this question will be tested
)
```

Then run: **"Test Focused"** configuration

**Remember to remove `focused = true` before publishing!**

## Common Errors and Solutions

### Error: "no way to verify generated receivers"

**Cause**: Class question without verification method, or non-static template method.

**Solution 1 - Class Questions**: Add a getter method
```java
public class Dog {
  private String name;
  public Dog(String setName) { name = setName; }

  // Add this
  public String getName() { return name; }
}
```

**Solution 2 - Template Questions**: Mark method as `static`
```java
// ❌ BAD
public void run() {
  // TEMPLATE_START
  // ...
  // TEMPLATE_END
}

// ✅ GOOD
public static void run() {
  // TEMPLATE_START
  // ...
  // TEMPLATE_END
}
```

### Error: Mutations Not Caught

**Cause**: Generated or fixed inputs don't trigger the mutation.

**Solutions**:
1. Add more @FixedParameters covering edge cases
2. Improve @RandomParameters to generate boundary cases
3. If mutation produces correct code, suppress it with mutation-disable comment

### Error: Question Takes Too Long to Validate

**Cause**: Expensive random generation or too many test cases.

**Solutions**:
1. Reduce complexity of @RandomParameters
2. Use simpler input generation
3. Add timeout limits in @Correct annotation
4. Check for infinite loops in solution

### Error: Import Statements Not Working

**Cause**: Missing imports in the question file.

**Solution**: Add all necessary imports at the top:
```java
import java.util.List;
import java.util.Arrays;
import edu.illinois.cs.cs125.questioner.lib.Generators;
```

Students will have access to these imports automatically.

### Error: Compilation Errors in Generated Tests

**Cause**: Type mismatches in parameter generation.

**Solution**: Ensure @RandomParameters return type matches method signature:
```java
// For: int addOne(int value)
@RandomParameters
private static int randomInts(Random random) {  // Returns int
  return random.nextInt();
}

// For: String combine(String first, String second)
@RandomParameters
private static Two<String, String> randomStrings(Random random) {  // Returns Two<String, String>
  return new Two<>("a", "b");
}
```

### Warning: Dead Code Detected

**Cause**: Unreachable code or unused variables in solution.

**Solutions**:
1. Remove dead code if it's truly unnecessary
2. If intentional (e.g., for memoization tests), increase `maxDeadCode`:
```java
@Correct(
    name = "Question",
    version = "2025.11.0",
    maxDeadCode = 2
)
```

## Best Practices

### 1. Package Organization

```
src/main/java/edu/illinois/cs/cs124/questioner/yournetid/
├── topic1/
│   ├── question1/
│   │   └── Question.java
│   └── question2/
│       └── Question.java
└── topic2/
    └── question3/
        └── Question.java
```

**Do NOT use**: `com.examples.*` (ignored during upload)

### 2. Version Numbering

Follow date-based versioning strictly:
- **New question**: `2025.11.0`
- **Update in same month**: `2025.11.1`, `2025.11.2`, etc.
- **Update in new month**: `2025.12.0` (reset minor to 0)
- **New year**: `2026.1.0`

### 3. Problem Descriptions

**Good descriptions**:
- Clear and concise
- Use code formatting: `methodName`, `ClassName`
- Specify input constraints
- Give examples
- State return requirements

**Example**:
```java
/*
 * Write a method `larger` that returns the larger of two `int` arguments.
 * For example, `larger(5, 3)` should return `5`, and `larger(2, 8)` should return `8`.
 * You may assume both inputs are different.
 */
```

### 4. Test Input Strategy

**Always provide both**:
1. **@FixedParameters** - Edge cases and specific scenarios
2. **@RandomParameters** - General case coverage

**Example**:
```java
// Cover edge cases
@FixedParameters
private static final List<Integer> FIXED = Arrays.asList(0, 1, -1, 88, Integer.MAX_VALUE);

// Cover general cases
@RandomParameters
private static int randomInts(Random random) {
  return random.nextInt();
}
```

### 5. Mutation Suppression Strategy

**Only suppress mutations when**:
1. The mutation produces semantically equivalent code
2. You've verified it's impossible to distinguish
3. You've documented why with a comment

**Example**:
```java
// mutate-disable-conditional-boundary: >= and > are equivalent here since we return immediately
if (first > second) {
  return first;
}
```

### 6. Recursive Questions

For recursive problems:
- Test base cases explicitly with @FixedParameters
- Include invalid inputs if applicable
- Consider stack depth limits
- Test boundary conditions

```java
@FixedParameters
private static final List<Long> FIXED = Arrays.asList(-10L, -1L, 0L, 1L, 2L, 20L);
```

### 7. String Questions

For String problems:
- Test empty strings
- Test null inputs (if allowed)
- Test special characters
- Consider using `Generators.randomAlphanumericStringWithLength()`

```java
@RandomParameters
private static String randomStrings(Random random) {
  return Generators.randomAlphanumericStringWithLength(random, random.nextInt(32));
}
```

### 8. Validation Workflow

**Recommended workflow**:
1. Write solution with `focused = true`
2. Run **"Test Focused"** repeatedly while developing
3. Review `report.html` for missed mutations
4. Add @FixedParameters for edge cases
5. Improve @RandomParameters as needed
6. Remove `focused = true`
7. Run **"Test All"** to ensure no conflicts
8. Review final `report.html`
9. Commit when clean

### 9. Code Style

- Follow Java/Kotlin conventions
- Use meaningful variable names
- Keep solutions simple and clear
- Avoid clever tricks - students should understand
- Add comments for complex logic
- Use `@SuppressWarnings` for intentional style violations

### 10. Repository Hygiene

**Never commit**:
- Solution code to public repositories
- Sensitive credentials
- Large binary files

**Do commit**:
- `.question.json` files
- Question source files
- `correct/` and `incorrect/` subdirectories
- Documentation and examples

### 11. Testing Before Publishing

**Final checklist**:
- [ ] `./gradlew cleanQuestions collectQuestions` succeeds
- [ ] `./gradlew test` passes
- [ ] Review `report.html` - all mutations caught or suppressed
- [ ] Problem description is clear
- [ ] Version number follows convention
- [ ] No `focused = true` in @Correct
- [ ] Tested both correct and incorrect submissions manually
- [ ] Kotlin support added if desired
- [ ] Package name is not `com.examples.*`

## Quick Reference

### Common Annotations

| Annotation | Purpose | Usage |
|------------|---------|-------|
| `@Correct` | Mark solution | Required on main question |
| `@AlsoCorrect` | Alternative solution | Kotlin alternatives |
| `@Incorrect` | Wrong solution | Common mistakes |
| `@Wrap` | Method-only template | Method questions |
| `@FixedParameters` | Specific test inputs | Edge cases |
| `@RandomParameters` | Random test inputs | General coverage |

### Common Imports

```java
// Core
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;

// Testing
import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.jenisol.core.Two;  // or Three, Four, etc.

// Utilities
import edu.illinois.cs.cs125.questioner.lib.Generators;
import java.util.Random;
```

### Gradle Tasks

| Task | Purpose |
|------|---------|
| `./gradlew collectQuestions` | Validate all questions |
| `./gradlew cleanQuestions` | Remove validation artifacts |
| `./gradlew test` | Run all tests |
| `./gradlew build` | Full build with validation |

### Directory Structure Template

```
questionname/
├── Question.java (or ClassName.java for class questions)
├── .question.json (generated)
├── report.html (generated)
├── correct/ (optional)
│   ├── kotlin/
│   │   └── Question.kt
│   └── java/
│       └── Question.java
└── incorrect/ (optional)
    ├── mistake1/
    │   └── Question.java
    └── mistake2/
        └── Question.java
```

## Additional Resources

- [README.md](README.md) - Repository overview
- [Tutorial Videos](README.md#getting-started) - Video walkthroughs
- [Questioner GitHub](https://github.com/cs125-illinois/questioner) - Main library
- Example questions in `com.examples.*` - Reference implementations

## Getting Help

If you encounter issues:
1. Check the [Common Errors](#common-errors-and-solutions) section
2. Review the example questions in `com.examples.*`
3. Check `report.html` for detailed validation feedback
4. Review relevant tutorial videos
5. Consult the Questioner documentation

Remember: The examples in this repository are your best resource. When in doubt, find a similar example and follow its pattern.
