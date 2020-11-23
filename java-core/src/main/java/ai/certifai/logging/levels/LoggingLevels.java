package ai.certifai.logging.levels;


import org.apache.log4j.Logger;

public class LoggingLevels {
    /**
     *  Logging levels in SLF4J could be arranged as below :
     *  DEBUG < INFO < WARN < ERROR where DEBUG is the highest level of logging
     *
     *  The functionality of each logging level explained below:
     *     DEBUG	Designates fine-grained informational events that are most useful to debug an application.
     *     INFO	    Designates informational messages that highlight the progress of the application at coarse-grained level.
     *     WARN	    Designates potentially harmful situations.
     *     ERROR	Designates error events that might still allow the application to continue running.
     *
     *  There is also another level called TRACE which provides more detailed info than DEBUG,
     *  yet SLF4J specifically recommends against using trace as log request in TRACE level could be wasteful.
     *  (http://slf4j.org/faq.html#trace)
     *
     *  FATAL level in log4j is not supported in SLF4J anymore as it provides nearly the same functionality as the
     *  ERROR level.
     *
     *  @author alvinwong
     */


    public static void main(String[] args) {
        //  TODO:   Try to change the logging level in configuration file (log4j.properties) and
        //          run this program to take a look at which logging messages will be printed out.
        Logger log = Logger.getLogger(LoggingLevels.class);
        log.debug("Giving info that are useful to debug a program.");
        log.info("Giving info that highlight the process of a program.");
        log.warn("Giving info that harmful situation might occurs.");
        log.error("Giving info that error events might occurs yet still allow program to run.");
        log.trace("Giving more detailed info than DEBUG mode");
    }
}
