package ai.certifai.logging.frameworks;


import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;

public class FrameworkExamples {
    /**
     *
     *  Java does provide a built-in logger since jdk 1.4 which allows user to do logging for their program.
     *  The logger could be imported via java.util.logging.Logger.
     *
     *  There are a lot of open-sourced Java Logging Frameworks out there too. In this tutorial, we will give examples
     *  on some of the popular frameworks.
     *
     *  In this tutorial, we will be implementing the logging framework directly (without slf4j bindings) for demonstration purposes.
     *
     *  @author alvinwong
     */
    public static void main(String[] args) {

        // Log4j V1 could de directly implement as below
        Logger log4jv1 = Logger.getLogger(FrameworkExamples.class);
        log4jv1.info("Log4jV1 over here");

        // Log4j V2 could de directly implement as below
        org.apache.logging.log4j.Logger log4jv2 = LogManager.getLogger(FrameworkExamples.class);
        log4jv2.info("Log4jv2 over here");

        // JUL could de directly implement as below
        java.util.logging.Logger JUL = java.util.logging.Logger.getLogger(FrameworkExamples.class.getName());
        JUL.info("JUL over here");

        // Logback natively uses SLF4J, to use Logback, need to have SLF4J dependencies
        org.slf4j.Logger logback = LoggerFactory.getLogger(FrameworkExamples.class);
        logback.info("Logback with slf4j");
    }
}
