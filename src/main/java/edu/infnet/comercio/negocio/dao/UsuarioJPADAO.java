package edu.infnet.comercio.negocio.dao;

import edu.infnet.comercio.negocio.JpaDAO;
import edu.infnet.comercio.negocio.modelo.Usuario;

public class UsuarioJPADAO extends JpaDAO<Usuario, Integer> {
	
	public UsuarioJPADAO() {
		super(Usuario.class);
	}
}
