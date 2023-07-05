package bg.proxiad.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sayhello")
public class SayHelloServlet extends HttpServlet {

  private static final long serialVersionUID = 2L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

		resp.getWriter().write("Hello from a servlet");
	}
	
}
