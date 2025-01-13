package org.example.repositorio;

import org.example.entity.Departamento;
import org.example.entity.Empleado;
import org.example.entity.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Repositorio para gestionar la entidad Empleado.
 * Proporciona métodos para realizar operaciones CRUD en los empleados.
 *
 * @autor oscarruiz-code
 */
public class EmpleadoRepository {

    private SessionFactory factory;

    public EmpleadoRepository() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Empresa.class)
                .addAnnotatedClass(Departamento.class)
                .addAnnotatedClass(Empleado.class)
                .buildSessionFactory();
    }

    public void guardarEmpleado(Empleado empleado) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(empleado);
            session.getTransaction().commit();
        }
    }

    public Empleado obtenerEmpleadoPorId(int id) {
        Empleado empleado = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            empleado = session.get(Empleado.class, id);
            session.getTransaction().commit();
        }
        return empleado;
    }

    public void eliminarEmpleado(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                session.delete(empleado);
            }
            session.getTransaction().commit();
        }
    }

    public void cerrar() {
        factory.close();
    }
}
