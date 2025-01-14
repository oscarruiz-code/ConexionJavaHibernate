package org.example.Manejador;

import org.example.entity.Departamento;
import org.example.entity.Empresa;
import org.example.repositorio.DepartamentoRepository;
import org.example.repositorio.EmpresaRepository;

import java.util.Scanner;

/**
 * Clase para gestionar las operaciones relacionadas con los departamentos.
 *
 * @autor oscarruiz-code
 */
public class ManejadorDepartamento {

    private Scanner scanner;
    private DepartamentoRepository departamentoRepository;
    private EmpresaRepository empresaRepository;

    public ManejadorDepartamento() {
        scanner = new Scanner(System.in);
        departamentoRepository = new DepartamentoRepository();
        empresaRepository = new EmpresaRepository();
    }

    public void ingresarDepartamentos() {
        while (true) {
            System.out.println("Ingrese el nombre del departamento:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el ID de la empresa a la que pertenece el departamento:");
            int empresaId = scanner.nextInt();
            scanner.nextLine();

            Empresa empresa = empresaRepository.obtenerEmpresaPorId(empresaId);
            if (empresa != null) {
                Departamento departamento = new Departamento(nombre, empresa);
                departamentoRepository.guardarDepartamento(departamento);
            } else {
                System.out.println("Empresa no encontrada.");
            }
            break;
        }
        System.out.println("Operación completada.");

    }

    public void actualizarDepartamento() {
        System.out.println("Ingrese el ID del departamento:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Departamento departamento = departamentoRepository.obtenerDepartamentoPorId(id);

        if (departamento != null) {
            System.out.println("Ingrese el nuevo nombre del departamento:");
            String nombre = scanner.nextLine();
            departamento.setNombre(nombre);

            System.out.println("Ingrese el nuevo ID de la empresa a la que pertenece el departamento:");
            int empresaId = scanner.nextInt();
            scanner.nextLine();
            Empresa empresa = empresaRepository.obtenerEmpresaPorId(empresaId);

            if (empresa != null) {
                departamento.setEmpresa(empresa);
                departamentoRepository.guardarDepartamento(departamento);
                System.out.println("Departamento actualizado.");
            } else {
                System.out.println("Empresa no encontrada.");
            }
        } else {
            System.out.println("Departamento no encontrado.");
        }
        System.out.println("Operación completada.");
    }

    public void eliminarDepartamento() {
        System.out.println("Ingrese el ID del departamento:");
        int id = scanner.nextInt();
        scanner.nextLine();
        departamentoRepository.eliminarDepartamento(id);
        System.out.println("Departamento eliminado.");
        System.out.println("Operación completada.");
    }

    public void mostrarDepartamento() {
        System.out.println("Ingrese el ID del departamento:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Departamento departamento = departamentoRepository.obtenerDepartamentoPorId(id);

        if (departamento != null) {
            System.out.println("ID: " + departamento.getId());
            System.out.println("Nombre: " + departamento.getNombre());
            System.out.println("Empresa: " + departamento.getEmpresa().getNombre());
        } else {
            System.out.println("Departamento no encontrado.");
        }
        System.out.println("Operación completada.");
    }

    public void cerrar() {
        departamentoRepository.cerrar();
        empresaRepository.cerrar();
    }
}
