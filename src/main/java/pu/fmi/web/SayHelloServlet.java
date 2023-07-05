package pu.fmi.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(urlPatterns = "/say-hello-my-way") moved to the web.xml
public class SayHelloServlet extends HttpServlet {

  private static final long serialVersionUID = 4L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

		String name = req.getParameter("name");

    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");
		resp.setHeader("content-type", "text/html;charset=utf-8");
    String greeting = getInitParameter("greeting");
    // String greeting = (String) getServletContext().getAttribute("greeting");
    resp.getWriter().write("<html><body>" + greeting + " " + name + "</body></html>");
	}
	
}
