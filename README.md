# Questioner Problems

This repository contains examples of how to utilize the [`questioner`](https://github.com/cs125-illinois/questioner)
library for writing small Java and Kotlin problems.
`questioner` is a tool that enables rapid authoring of robust Java and Kotlin homework problems. Rather than writing
test suites, you simply provide a solution and a problem description.
`questioner` then generates a testing strategy that ensures that submissions under test are designed and behave
identically to the reference solution.

`questioner` can autogenerate inputs for many standard Java and Kotlin types. It also allows you to easily override the
autogenerated inputs to support problems that require inputs with special properties, and provide ways to generate and
compare other types needed to test specific problems.
`questioner` simplifies working with common Java (and Kotlin) types, but can support problems that use custom types.

`questioner` utilizes mutation to generate incorrect submissions to test the testing strategy based only on the
solution. You can also provide manually-annotated examples representing common mistakes that you want to be sure are
marked as incorrect.

## Getting Your Copy

**Please do not fork this repository.**
`questioner` repositories contain solution code and so must remain private. Unfortunately GitHub does not allow forks of
public repositories to be private, or allow forking to be disabled.

Instead, here is how to set up a private copy of the `questioner-problems` repository in a way that allows you to access
upstream changes.

First, clone—don't fork—the repository onto your local machine. Second, create a new empty _private_ repository, on
GitHub or anywhere you can create private Git repositories.

Next, in a shell in your local clone of `questioner-problems`:

```sh
git remote rename origin upstream
git remote add origin <url>
git push -u origin main
```

Where `<url>` is the URL of the private repository you created above.

### Receiving Updates

From time to time will update this repository with new examples, tutorials, or with changes to the Gradle or IntelliJ
configurations. To receive these changes, first make sure that your Git working directory is clean and you have
committed any of your latest changes. Next, run the following commands:

```sh
git fetch upstream
git merge upstream/main
```

Assuming you are working in your own package as suggested below, changes that we make upstream should not conflict with
your local changes. However, when you receive upstream changes it is useful to rerun all of your validations. Simply use
the "Reset All Validations" IntelliJ run configuration and then "Test All".

### Java Version

`questioner` requires Java 17, which you will need to download and install to use this tool.
If you are on a UNIX-like system, including MacOS, we suggest using [`asdf`](https://asdf-vm.com/) to manage tools versions.
The repository includes an `asdf` `.tool-versions` configuration file specifying Java 17.

## Getting Started

The best approach is to work through the following examples in order. Each has an accompanying YouTube video tutorial.
More tutorials will be added here as needed to explain additional aspects of the `questioner` system.

## 0. `com.examples.addone`

[Tutorial link](https://youtu.be/-Z3EDpuylrY).

Demonstrates the basic components of the most simple possible problem, including the problem description and `@Correct`
metadata. Also discusses the `@Wrap` annotation for supporting method-only problems.

## 1. `com.examples.equals88`

[Tutorial link](https://youtu.be/2Nw07GMBPcs).

Shows how to use `@FixedParameter` and `@RandomParameter` annotations to handle problems that require special inputs.

## 2. `com.examples.combineminustwo`

[Tutorial link](https://youtu.be/gjuxIizO8Oc).

Demonstrates how to work with `String`s, multiple parameters, and several approaches to parameter filtering.

## 3. `com.examples.printsum`

[Tutorial link](https://youtu.be/ozViMtSBYIs).

Shows how to set up a snippet-based question and formulate questions that print instead of returning.

## 4. `com.examples.counterobject`

[Tutorial link](https://youtu.be/60SqkB2xiu4).

Simple example of a class-based question.

## 5. `com.examples.largestoftwo`

[Tutorial link](https://youtu.be/EtmWlWeAlEE).

Demonstrates how to suppress a mutation that produces correct code and discusses some situations where this can occur.

## 6. `com.examples.fancystringcompare`

[Tutorial link](https://youtu.be/SDpbrumaU2s).

Discuss several different ways of handling `null`, writing solutions that `throw` exceptions, and manually adding and
marking incorrect examples using `@Incorrect`.

## 7. Kotlin Support

[Tutorial link](https://youtu.be/0pAASQTuCUI).

Describes how to add Kotlin support to both a method-based problem (`addone`) and to a class-based
problem (`counterobject`).

# Authoring Problems

You are free to author problems in a fork of this repository.
**However, please be aware that your repository will contain solution code!
Therefore it _must_ be kept private.**
We will not accept problems for use on course assessments that are maintained in public repositories.

Please put them under an appropriate package name. Note that anything under `com.examples` is ignored during problem
upload, so choose a different package name. If you are working on problems for CS
124, `edu.illinois.cs.cs124.questioner.<Your NetID>` may be an appropriate package root and help avoid conflicts with
other other authors.

# FAQ

## 1. What does the error "no way to verify generated receivers" mean?

### If you were trying to author a class-based question...

When you author a class-based question, `questioner` needs two things

1. a way to create receivers (instances of your class), and
2. a way to _verify_ receivers that are generated to make sure they behave properly.

Consider the following example:

```java
public class Dog {
  private String name;

  public Dog(String setName) {
    name = setName;
  }
}
```

While `questioner` can create `Dog`s using the provided public constructor (requirement #1 above), it has no way to
extract any information from the generated instances to ensure the submission and solution behave identically.

One easy way to fix this is to add a getter:

```java
public class Dog {
  private String name;

  public Dog(String setName) {
    name = setName;
  }

  public String getName() {
    return name;
  }
}
```

Now after creating instances of the solution and submission `Dog`, `questioner` will call `getName` to retrieve
the `String` and check that they match.

### If you were trying to author a templated question...

You can also see this error message if you are building a question that accepts a snippet but the wrapper function
is `void` and not marked as `static`:

```java
public class Question {
  public void run() {
    // TEMPLATE_START
    System.out.println("Hello, world!");
    // TEMPLATE_END
  }
}
```

In the example above, `questioner` will interpret the entire question as a class-based question.
(There are valid use cases for templates inside class-based questions, so we can't easily reject this.)
During testing instances of `Question` will be created, but there is no way to retrieve a value for them, hence the error message.

Happily the fix is simple: just mark the method containing the template as `static`:

```java
public class Question {
  public static void run() {
    // TEMPLATE_START
    System.out.println("Hello, world!");
    // TEMPLATE_END
  }
}
```

Now `questioner` won't create instances or need to extract data from them. Problem solved.
