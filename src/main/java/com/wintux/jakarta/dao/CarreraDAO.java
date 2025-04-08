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
	// Obtener una carrera por su ID
	public Carrera obtenerCarreraPorId(int id) {
		Transaction tx = null;
		List<Carrera> lista = null;
		Session sesion= HibernateUtil
				.getSessionfactory()
				.openSession();
	    try {
	            return sesion.get(Carrera.class, id);
	    }catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			sesion.close();
		}
	    return null;
	}
	//Regsitrar una carrera nueva
	public void guardarCarrera(Carrera carrera) {
        Transaction transaction = null;
        try (Session sesion = HibernateUtil.getSessionfactory().openSession()) {
            transaction = sesion.beginTransaction();
            sesion.persist(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
	// Modificar una carrera
    public void actualizarCarrera(Carrera carrera) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // Eliminar una carrera
    public void eliminarCarrera(Carrera carrera) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
