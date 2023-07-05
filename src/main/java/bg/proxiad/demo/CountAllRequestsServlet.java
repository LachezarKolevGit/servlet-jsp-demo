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

@WebServlet("/count-all-request")
public class CountAllRequestsServlet extends HttpServlet {
  private static final long serialVersionUID = 35L;

  public static final String TOTAL_CLICKS_ATTR = "totalClicks";

  @Override
  public void init() throws ServletException {
    getServletContext().setAttribute(TOTAL_CLICKS_ATTR, Integer.valueOf(0));
    super.init();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session = request.getSession();
    ServletContext servletContext = session.getServletContext();
    
    int totalClicks = 0;
    if (servletContext.getAttribute(TOTAL_CLICKS_ATTR) != null) {
      totalClicks = (int) servletContext.getAttribute(TOTAL_CLICKS_ATTR);
    } else {
      servletContext.setAttribute(TOTAL_CLICKS_ATTR, Integer.valueOf(totalClicks));
    }
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response
        .getWriter()
        .append(format("<html><body><p>Total counter: %d</p></body></html>", totalClicks));
	}

}
