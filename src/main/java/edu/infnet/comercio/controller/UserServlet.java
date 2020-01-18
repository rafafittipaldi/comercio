package edu.infnet.comercio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UserSrv"})
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8541293463576430759L;

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		String login = (String) req.getParameter("login");
		String senha = (String) req.getParameter("senha");
		
		System.out.println(" O Login foi " + login);
		System.out.println(" A Senha foi " + senha);
		
		req.getSession().setAttribute("user", login);
		req.getRequestDispatcher("pages/home.jsp")
			.forward(req, resp);
	}
}
