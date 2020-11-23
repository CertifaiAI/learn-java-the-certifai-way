# Brief Guide of Java Logging

### Introduction
#### Why should we do logging?

Logging is the process of writing log messages during the execution of a program to a central place. 
We want to log the meaningful events that occurs during the execution of the program for user to analyze later.
We would also want to report any potential error or some warning messages to the user so that user could understand 
more what to do to solve it. 

#### Examples of log messages 

Sometimes we might just want to log some system's state or user's
action to a file, so we could have a record of what's happening during
the execution of the program.

```java
    log.info("Application succesfully runned with time {} s", timeTaken);
```

It could be we want to record the error messages whenever an exception
occurs and log the error messages for the expert to resolve later.

```java
    log.error("Program crashed unexpectedly ", exception);
```

Or it might be some warnings that you want to record down and give information
to the user about it.

```java
    log.warn("Invalid user id/password, please try again.");
```

No matter what kind of message you want to record, you need to have an appropriate logging library
to use it. There are some java logging libraries out there for you to use.


#### Java Logging Library/Framework

**java.util.logging (JUL)**

Since Java 1.4 there is a built-in Logging Framework provided by the JDK.
But due to slow performance and documentation, other open-sourced logging framework
has been introduced.

**Log4j (v1)**

Log4j is a reliable, fast and flexible logging framework (APIs) written in Java,
which highly configurable through external configuration files at runtime.

**Log4j (v2)**
 
 Log4j v2 is an upgrade to Log4j that provides significant improvements over its predecessor, Log4j v1.
 It is currently the newest logging framework that has been introduced.

**SLF4J**

The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j)
 allowing the end user to plug in the desired logging framework at deployment time. SLF4J allows the user to switch between different logging
 framework by just changing the bindings in the class path.

**Logback**

Logback is one of the most widely used logging frameworks in the Java Community. It was meant to become a successor for Log4j v1 and it 
is designed by the same author. It is faster and has a smaller footprint than other existing logging systems and supports SLF4J natively.