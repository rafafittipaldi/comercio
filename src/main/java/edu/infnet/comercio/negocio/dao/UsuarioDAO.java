package edu.infnet.comercio.negocio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.infnet.comercio.negocio.MySqlConnection;
import edu.infnet.comercio.negocio.modelo.Usuario;

public class UsuarioDAO {
	
	private static Logger logger  = LogManager.getLogger(UsuarioDAO.class);
	
	private Connection        con;
	private PreparedStatement pstm;
	private ResultSet         rs;
	
	public UsuarioDAO() {
		this.con = MySqlConnection.getConnection();
	}
	
	public Boolean save(Usuario usuario) {
		
		String sql = "insert into usuario(login, senha) values (?, ?)";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			logger.error("Erro ao salvar usuário!", e);
		}
		
		return false;
	}
	
	public Usuario getByLogin(String login) {
		
		String sql = "select id, login, senha from usuario where login = ?";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, login);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				Integer id    = rs.getInt(1);
				String _login = rs.getString(2);
				String senha  = rs.getString(3);
				
				return new Usuario(id, _login, senha);
			}
		} catch (Exception e) {
			logger.error("Erro ao buscar usuário!", e);
		}
		return null;
	}
}
