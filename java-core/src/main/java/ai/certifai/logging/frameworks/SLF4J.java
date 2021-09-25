package ai.certifai.logging.frameworks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4J {

    /**
     *
     *  SLF4J acts like an abstraction / interface for end-user to switch between different logging framework
     *  by just changing the jar files in the class path. This could be very helpful as when you want to switch
     *  to different logging framework (eg: JUL to log4j), you don't have to change the imports in each java program,
     *  instead you just have to change the dependencies in the pom.xml file (if you are on a maven project).
     *
     *  The slf4j binding for some of the logging frameworks are included in the pom.xml file.
     *  To try out different logging framework, just simply uncomment your desired slf4j binding and comment out
     *  the current binding (default is using logback).
     *
     *  If multiple bindings are found in the class path, the slf4j will prompt a warning. Select only one of the
     *  binding to be used.
     *
     *  See 'http://www.slf4j.org/codes.html#multiple_bindings' for an explanation.
     *
     * @author alvinwong
     */

    public static void main(String[] args) {
        // TODO: Try to switch between different logging frameworks by changing the dependencies in the pom.xml file

        // Declaring a slf4j logger
        Logger log = LoggerFactory.getLogger(SLF4J.class);
        log.info("Hello World");
    }
}
