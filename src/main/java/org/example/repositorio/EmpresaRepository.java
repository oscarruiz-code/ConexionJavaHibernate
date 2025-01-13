package org.example.repositorio;

import org.example.entity.Departamento;
import org.example.entity.Empleado;
import org.example.entity.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Repositorio para gestionar la entidad Empresa.
 * Proporciona métodos para realizar operaciones CRUD en las empresas.
 *
 * @autor oscarruiz-code
 */
public class EmpresaRepository {

    private SessionFactory factory;

    public EmpresaRepository() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empresa.class)
                .addAnnotatedClass(Departamento.class)
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();
    }

    public void guardarEmpresa(Empresa empresa) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(empresa);
            session.getTransaction().commit();
        }
    }

    public Empresa obtenerEmpresaPorId(int id) {
        Empresa empresa = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            empresa = session.get(Empresa.class, id);
            session.getTransaction().commit();
        }
        return empresa;
    }

    public void eliminarEmpresa(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Empresa empresa = session.get(Empresa.class, id);
            if (empresa != null) {
                session.delete(empresa);
            }
            session.getTransaction().commit();
        }
    }

    public void cerrar() {
        factory.close();
    }
}
