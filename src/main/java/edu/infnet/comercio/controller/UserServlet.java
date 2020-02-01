package edu.infnet.comercio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.cj.util.StringUtils;

import edu.infnet.comercio.negocio.MySqlConnection;
import edu.infnet.comercio.negocio.dao.UsuarioDAO;
import edu.infnet.comercio.negocio.modelo.Usuario;

@WebServlet(urlPatterns = {"/UserSrv"})
public class UserServlet extends HttpServlet {
	
	private static Logger logger  = LogManager.getLogger(UserServlet.class);
	
	private static final long serialVersionUID = -8541293463576430759L;
	
	private UsuarioDAO dao;
	
	public UserServlet() {
		dao = new UsuarioDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		logger.debug("Entrando no doPost");
		
		//RECUPERAR OBJETO DA SESSÃO
		String action = (String) req.getParameter("action");
		String login  = (String) req.getParameter("login");
		String senha  = (String) req.getParameter("senha");
		
		if("new".equals(action)) {
			
			//VALIDAR OS VALORES
			if(StringUtils.isEmptyOrWhitespaceOnly(login)) {
				
			}
			
			if(StringUtils.isEmptyOrWhitespaceOnly(senha)) {
				
			}
			
			//TODO CONVERTER OS VALORES
			//TODO APLICAR AO MODELO
			Usuario usuario = new Usuario(login, senha);
			
			dao.save(usuario);
		}
		
		System.out.println(" O Login foi " + login);
		System.out.println(" A Senha foi " + senha);
		
		req.getSession().setAttribute("user", login);
		req.getRequestDispatcher("pages/home.jsp")
			.forward(req, resp);
	}
}
