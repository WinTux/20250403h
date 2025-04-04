package com.wintux.jakarta.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wintux.jakarta.HibernateUtil;
import com.wintux.jakarta.models.Carrera;

public class CarreraDAO {
	public List<Carrera> obtenerTodasLasCarreras(){
		Transaction tx = null;
		List<Carrera> lista = null;
		Session sesion= HibernateUtil
				.getSessionfactory()
				.openSession();
		try {
			tx = sesion.beginTransaction();
			lista = sesion.createQuery("SELECT c FROM Carrera c",Carrera.class).list();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			sesion.close();
		}
		return lista;
	}
}
