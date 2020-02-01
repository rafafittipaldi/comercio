package edu.infnet.comercio.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.infnet.comercio.negocio.MySqlConnection;
import edu.infnet.comercio.negocio.modelo.Produto;

public class ProdutoDAO {

	private static Logger logger  = LogManager.getLogger(ProdutoDAO.class);
	
	private Connection        con;
	private PreparedStatement pstm;
	private ResultSet         rs;
	
	public ProdutoDAO() {
		this.con = MySqlConnection.getConnection();
	}
	
	public List<Produto> findAllProdutos() {
		
		String sql = "select * from produto";
		List<Produto> listProduto = new ArrayList<Produto>();
		
		try {
			pstm = con.prepareStatement(sql);
			rs   = pstm.executeQuery();
			
			while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setId       (rs.getInt   ("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setFoto     (rs.getString("foto"));
				produto.setNome     (rs.getString("nome"));
				produto.setPreco    (rs.getDouble("preco"));
				
				listProduto.add(produto);
			}
			
		} catch (Exception e) {
			logger.error("Erro ao recuperar produtos!", e);
		}
		return listProduto;
	}
}
