package org.example.repositorio;

import org.example.entity.Departamento;
import org.example.entity.Empleado;
import org.example.entity.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DepartamentoRepository {

    private SessionFactory factory;

    public DepartamentoRepository() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empresa.class)
                .addAnnotatedClass(Departamento.class)
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();
    }

    public void guardarDepartamento(Departamento departamento) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(departamento);
            session.getTransaction().commit();
        }
    }

    public Departamento obtenerDepartamentoPorId(int id) {
        Departamento departamento = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            departamento = session.get(Departamento.class, id);
            session.getTransaction().commit();
        }
        return departamento;
    }

    public void eliminarDepartamento(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Departamento departamento = session.get(Departamento.class, id);
            if (departamento != null) {
                session.delete(departamento);
            }
            session.getTransaction().commit();
        }
    }

    public void cerrar() {
        factory.close();
    }
}
