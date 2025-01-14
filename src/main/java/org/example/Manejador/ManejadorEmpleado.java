package org.example.Manejador;

import org.example.entity.Departamento;
import org.example.entity.Empleado;
import org.example.repositorio.DepartamentoRepository;
import org.example.repositorio.EmpleadoRepository;

import java.util.Scanner;

/**
 * Clase para gestionar las operaciones relacionadas con los empleados.
 *
 * @autor oscarruiz-code
 */
public class ManejadorEmpleado {

    private Scanner scanner;
    private EmpleadoRepository empleadoRepository;
    private DepartamentoRepository departamentoRepository;

    public ManejadorEmpleado() {
        scanner = new Scanner(System.in);
        empleadoRepository = new EmpleadoRepository();
        departamentoRepository = new DepartamentoRepository();
    }

    public void ingresarEmpleados() {
        while (true) {
            System.out.println("Ingrese el nombre del empleado :");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del empleado:");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese el puesto del empleado:");
            String puesto = scanner.nextLine();
            System.out.println("Ingrese el ID del departamento al que pertenece el empleado:");
            int departamentoId = scanner.nextInt();
            scanner.nextLine();

            Departamento departamento = departamentoRepository.obtenerDepartamentoPorId(departamentoId);
            if (departamento != null) {
                Empleado empleado = new Empleado(nombre, apellido, puesto, departamento);
                empleadoRepository.guardarEmpleado(empleado);
            } else {
                System.out.println("Departamento no encontrado.");
            }
            break;
        }
        System.out.println("Operación completada.");
    }


    public void actualizarEmpleado() {
        System.out.println("Ingrese el ID del empleado que desea actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Empleado empleado = empleadoRepository.obtenerEmpleadoPorId(id);

        if (empleado != null) {
            System.out.println("Ingrese el nuevo nombre del empleado:");
            String nombre = scanner.nextLine();
            empleado.setNombre(nombre);

            System.out.println("Ingrese el nuevo apellido del empleado:");
            String apellido = scanner.nextLine();
            empleado.setApellido(apellido);

            System.out.println("Ingrese el nuevo puesto del empleado:");
            String puesto = scanner.nextLine();
            empleado.setPuesto(puesto);

            System.out.println("Ingrese el nuevo ID del departamento al que pertenece el empleado:");
            int departamentoId = scanner.nextInt();
            scanner.nextLine();
            Departamento departamento = departamentoRepository.obtenerDepartamentoPorId(departamentoId);

            if (departamento != null) {
                empleado.setDepartamento(departamento);
                empleadoRepository.guardarEmpleado(empleado);
                System.out.println("Empleado actualizado.");
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Empleado no encontrado.");
        }
        System.out.println("Operación completada.");
    }

    public void eliminarEmpleado() {
        System.out.println("Ingrese el ID del empleado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        empleadoRepository.eliminarEmpleado(id);
        System.out.println("Empleado eliminado con éxito.");
        System.out.println("Operación completada.");
    }

    public void mostrarEmpleado() {
        System.out.println("Ingrese el ID del empleado:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Empleado empleado = empleadoRepository.obtenerEmpleadoPorId(id);

        if (empleado != null) {
            System.out.println("ID: " + empleado.getId());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Puesto: " + empleado.getPuesto());
            System.out.println("Departamento: " + empleado.getDepartamento().getNombre());
        } else {
            System.out.println("Empleado no encontrado.");
        }
        System.out.println("Operación completada.");
    }

    public void cerrar() {
        empleadoRepository.cerrar();
        departamentoRepository.cerrar();
    }
}
