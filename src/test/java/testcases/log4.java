package testcases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class log4 {
    private static final Logger logger = LogManager.getLogger(log4.class);

  @Test
  public void f() {
	  System.out.println("Hello ");
	  logger.trace(" trace We've just greeted the user!");
      logger.debug("debug We've just greeted the user!");
      logger.info(" info We've just greeted the user!");
      logger.warn(" warn We've just greeted the user!");
      logger.error("error We've just greeted the user!");
      logger.fatal(" fatal We've just greeted the user!");
  }
}
