package pu.fmi.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/say-hello-my-way-through-jsp")
public class SayHelloThroughJspServlet extends HttpServlet {

  private static final long serialVersionUID = 5L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

		String name = req.getParameter("name");
		req.setAttribute("name", name);

    String greeting = (String) getServletContext().getAttribute("greeting");
    req.setAttribute("greeting", greeting);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");
		dispatcher.forward(req, resp);
	}
	
}
