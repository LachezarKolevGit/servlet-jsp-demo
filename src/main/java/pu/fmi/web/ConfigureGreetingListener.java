package pu.fmi.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigureGreetingListener
    implements ServletContextListener { // wrapper listener class for changes to the ServletContext
  // at startup or shutdown of app

  public static final String SESSION_COUNTER_ATTR = "counterForSession";

  public static final Integer COUNTER_INIT_VALUE = 0;

  public static final String TOTAL_CLICKS_ATTR = "totalClicks";

  public static final Integer TOTAL_CLICKS_COUNTER_INIT_VALUE = 0;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // sce.getServletContext().setAttribute("greeting", "maraba"); // must be initialized from
    // web.xml

    sce.getServletContext().setAttribute(TOTAL_CLICKS_ATTR, TOTAL_CLICKS_COUNTER_INIT_VALUE);
    System.out.println(
        "Initializing " + TOTAL_CLICKS_ATTR + " with " + TOTAL_CLICKS_COUNTER_INIT_VALUE);
  }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	

	}
}
