package edu.infnet.comercio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.infnet.comercio.negocio.dao.ProdutoJPADAO;
import edu.infnet.comercio.negocio.modelo.Produto;

@WebServlet(urlPatterns = {"/ComprasSrv"})
public class ComprasServlet extends HttpServlet {
	
	private static final long serialVersionUID = -556376068832777121L;
	
	private ProdutoJPADAO prdJpaDao;
	
	public ComprasServlet() {
		this.prdJpaDao = new ProdutoJPADAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Produto> listProdutos = prdJpaDao.findAll();
		
		req.setAttribute("produtos", listProdutos);
		
		req.getRequestDispatcher("pages/catalogo.jsp")
			.forward(req, resp);
	}
}
