# Java Logging Framework
In this section, we will be mainly focusing on various logging framework with SLF4J bindings as
it serves as a simple facade or abstraction for them. With SLF4J we could easily switch between different framework, 
providing more flexibility in logging messages.


### SLF4J
To use SLF4J, we have to import the required dependencies.
```xml
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.26</version>
        </dependency>
```

To initialize a logger in a program, just simply import `org.slf4j.Logger` and uses `getLogger` method from the `LoggerFactory`.
```java
        Logger log = LoggerFactory.getLogger(Example.class);
```
 
 
 ### Log4j (v1)
 To use log4j v1 with SLF4J binding, the following dependencies should be imported:
```xml
        <!-- Log4J v1 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!-- SLF4j binding for Log4J v1 -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.26</version>
        </dependency>
```
 With these dependencies, we could have our logger running on log4j framework with SLF4J abstraction.
 
 ### Log4j (v2)
 To use log4j v2 with SLF4J binding, the following dependencies have to be imported:
 ```xml
        <!-- Log4J v2 -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.14.0</version>
        </dependency>

        <!-- SLF4j binding for Log4J v2 -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
            <version>2.14.0</version>
        </dependency>
```
   
  ### Logback
  Since logback natively supports SLF4J, therefore no additional SLF4J bindings are required, just simply import logback dependencies. 
```xml
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
```
