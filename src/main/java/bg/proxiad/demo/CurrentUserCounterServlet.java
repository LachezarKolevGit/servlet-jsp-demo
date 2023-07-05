package bg.proxiad.demo;

import static java.lang.String.format;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pu.fmi.web.ConfigureGreetingListener;

@WebServlet("/current-user-counter")
public class CurrentUserCounterServlet extends HttpServlet {
  private static final long serialVersionUID = 25L;

  public static final String SESSION_ATTRIBUTE_COUNTER = "counterForSession";

  public static final Integer COUNTER_INIT_VALUE = 0;

  @Override
  public void init() throws ServletException {
    super.init();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    if (session.getAttribute(SESSION_ATTRIBUTE_COUNTER) == null) { // new session
      session.setAttribute(SESSION_ATTRIBUTE_COUNTER, COUNTER_INIT_VALUE);
    }

    int counter = (int) session.getAttribute(ConfigureGreetingListener.SESSION_COUNTER_ATTR);
    ServletContext servletContext = session.getServletContext();
    int totalClicks =
        (int) servletContext.getAttribute(ConfigureGreetingListener.TOTAL_CLICKS_ATTR);

    counter++;
    totalClicks++;

    session.setAttribute(ConfigureGreetingListener.SESSION_COUNTER_ATTR, Integer.valueOf(counter));
    servletContext.setAttribute(
        CountAllRequestsServlet.TOTAL_CLICKS_ATTR, Integer.valueOf(totalClicks));

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().append(format("<html><body><p>Counter: %d</p></body></html>", counter));
  }
}
