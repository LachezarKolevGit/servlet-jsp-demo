package bg.proxiad.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHelloThroughJspServlet extends HttpServlet {

  private static final long serialVersionUID = 3L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String greeting = getInitParameter("greeting");
    req.setAttribute("greeting", greeting);
    String name = req.getParameter("name");
    req.setAttribute("name", name);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");
		dispatcher.forward(req, resp);
	}
	
}
