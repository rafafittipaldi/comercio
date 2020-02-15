package edu.infnet.comercio.negocio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaConnection {

	private static EntityManagerFactory emf;
	
	private JpaConnection() {}
	
	public static EntityManagerFactory getEmf() {
		if(null == JpaConnection.emf) {
			JpaConnection.emf = Persistence.createEntityManagerFactory("CRM-MySql-Comercio");
		}
		return emf;
	}
}
