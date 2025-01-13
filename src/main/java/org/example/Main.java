package org.example;

import org.example.entity.Departamento;
import org.example.entity.Empleado;
import org.example.entity.Empresa;
import org.example.repositorio.DepartamentoRepository;
import org.example.repositorio.EmpleadoRepository;
import org.example.repositorio.EmpresaRepository;

/**
 * Clase principal para ejecutar la aplicación.
 * Realiza operaciones CRUD utilizando los repositorios de Empresa, Departamento y Empleado.
 *
 * @autor oscarruiz-code
 */
public class Main {
    public static void main(String[] args) {

        EmpleadoRepository empleadoRepository = new EmpleadoRepository();
        EmpresaRepository empresaRepository = new EmpresaRepository();
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();

        Empresa empresa1 = new Empresa("Tech Innovations Inc.", "Tecnología");
        Empresa empresa2 = new Empresa("Green Solutions LLC", "Energías Renovables");
        empresaRepository.guardarEmpresa(empresa1);
        empresaRepository.guardarEmpresa(empresa2);

        Departamento departamento1 = new Departamento("Desarrollo de Software", empresa1);
        Departamento departamento2 = new Departamento("Recursos Humanos", empresa1);
        Departamento departamento3 = new Departamento("Investigación y Desarrollo", empresa2);
        Departamento departamento4 = new Departamento("Ventas y Marketing", empresa2);
        departamentoRepository.guardarDepartamento(departamento1);
        departamentoRepository.guardarDepartamento(departamento2);
        departamentoRepository.guardarDepartamento(departamento3);
        departamentoRepository.guardarDepartamento(departamento4);

        Empleado empleado1 = new Empleado("Juan", "Pérez", "Ingeniero de Software", departamento1);
        Empleado empleado2 = new Empleado("Laura", "Sánchez", "Gerente de Recursos Humanos", departamento2);
        Empleado empleado3 = new Empleado("Carlos", "López", "Científico de Investigación", departamento3);
        Empleado empleado4 = new Empleado("Ana", "Gómez", "Directora de Marketing", departamento4);
        Empleado empleado5 = new Empleado("Luis", "Ramírez", "Ingeniero de Software Junior", departamento1);
        empleadoRepository.guardarEmpleado(empleado1);
        empleadoRepository.guardarEmpleado(empleado2);
        empleadoRepository.guardarEmpleado(empleado3);
        empleadoRepository.guardarEmpleado(empleado4);
        empleadoRepository.guardarEmpleado(empleado5);

        empresaRepository.cerrar();
        departamentoRepository.cerrar();
        empleadoRepository.cerrar();

        System.out.println("Datos guardados correctamente.");
    }
}
