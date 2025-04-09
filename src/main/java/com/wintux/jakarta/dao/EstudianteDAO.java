package com.wintux.jakarta.dao;

import com.wintux.jakarta.models.Estudiante;
import com.wintux.jakarta.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EstudianteDAO {

    // Obtener a todos los estudiantes
    public List<Estudiante> obtenerTodosEst() {
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            Query<Estudiante> query = session.createQuery("FROM Estudiante", Estudiante.class);
            return query.list();
        }
    }
	// Obtener estudiante por matrícula
    public Estudiante obtenerPorMatricula(int matricula) {
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            return session.get(Estudiante.class, matricula);
        }
    }

    // Guardar un nuevo estudiante
    public void guardarEst(Estudiante estudiante) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(estudiante);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Actualizar un estudiante existente
    public void actualizarEst(Estudiante estudiante) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(estudiante);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // Eliminar un estudiante
    public void eliminarEst(Estudiante estudiante) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionfactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(estudiante);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
