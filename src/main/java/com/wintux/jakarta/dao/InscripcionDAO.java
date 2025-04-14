package com.wintux.jakarta.dao;

import com.wintux.jakarta.HibernateUtil;
import com.wintux.jakarta.models.Inscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.util.List;

public class InscripcionDAO {
    private final SessionFactory sessionFactory = HibernateUtil
			.getSessionfactory();

    public List<Inscripcion> obtenerTodas() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Inscripcion", Inscripcion.class).list();
        }
    }

    public List<Inscripcion> buscarPorNombreEstudiante(String substr) {
        try (Session session = sessionFactory.openSession()) {
            Query<Inscripcion> query = session.createQuery(
                "FROM Inscripcion i WHERE i.est.Nombre LIKE :substr", Inscripcion.class);
            query.setParameter("substr", "%" + substr + "%");
            return query.list();
        }
    }

    public List<Inscripcion> obtenerOrdenadasPorFecha() {
        try (Session session = sessionFactory.openSession()) {
            Query<Inscripcion> query = session.createQuery(
                "FROM Inscripcion i ORDER BY i.FechaInscripcion DESC", Inscripcion.class);
            return query.list();
        }
    }

    public List<Inscripcion> filtrarPorCalificacionMinima(BigDecimal minCalif) {
        try (Session session = sessionFactory.openSession()) {
            Query<Inscripcion> query = session.createQuery(
                "FROM Inscripcion i WHERE i.Calificacion > :minCalif", Inscripcion.class);
            query.setParameter("minCalif", minCalif);
            return query.list();
        }
    }

    public BigDecimal obtenerSumaCalificaciones() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "SELECT SUM(i.Calificacion) FROM Inscripcion i", BigDecimal.class)
                .uniqueResult();
        }
    }

    public Long contarInscripciones() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "SELECT COUNT(i) FROM Inscripcion i", Long.class)
                .uniqueResult();
        }
    }

    public Object[] obtenerMaxMinCalificaciones() {
        try (Session session = sessionFactory.openSession()) {
            return (Object[]) session.createQuery(
                "SELECT MAX(i.Calificacion), MIN(i.Calificacion) FROM Inscripcion i")
                .uniqueResult();
        }
    }

    public Double obtenerPromedioCalificaciones() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "SELECT AVG(i.Calificacion) FROM Inscripcion i", Double.class)
                .uniqueResult();
        }
    }

    public List<Object[]> obtenerProyeccionFechasCalificaciones() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "SELECT i.FechaInscripcion, i.Calificacion FROM Inscripcion i", Object[].class)
                .list();
        }
    }
}
