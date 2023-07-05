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

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    String greeting = (String) getServletContext().getAttribute("greeting");
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");

    req.setAttribute("name", name);
    req.setAttribute("greeting", greeting);
    dispatcher.forward(req, resp);
  }
}
