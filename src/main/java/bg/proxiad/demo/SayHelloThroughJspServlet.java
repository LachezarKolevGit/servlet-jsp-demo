package bg.proxiad.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHelloThroughJspServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String greeting = getInitParameter("greeting");
    String name = req.getParameter("name");
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");

    req.setAttribute("greeting", greeting);
    req.setAttribute("name", name);
    dispatcher.forward(req, resp);
  }
}
