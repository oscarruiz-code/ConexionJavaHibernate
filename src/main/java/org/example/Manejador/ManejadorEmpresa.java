package org.example.Manejador;

import org.example.entity.Empresa;
import org.example.repositorio.EmpresaRepository;

import java.util.Scanner;

/**
 * Clase para gestionar las operaciones relacionadas con las empresas.
 *
 * @autor oscarruiz-code
 */
public class ManejadorEmpresa {

    private Scanner scanner;
    private EmpresaRepository empresaRepository;

    public ManejadorEmpresa() {
        scanner = new Scanner(System.in);
        empresaRepository = new EmpresaRepository();
    }

    public void ingresarEmpresas() {
        while (true) {
            System.out.println("Ingrese el nombre de la empresa:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la industria de la empresa:");
            String industria = scanner.nextLine();

            Empresa empresa = new Empresa(nombre, industria);
            empresaRepository.guardarEmpresa(empresa);
            break;
        }
        System.out.println("Operación completada.");
    }


    public void actualizarEmpresa() {
        System.out.println("Ingrese el ID de la empresa:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Empresa empresa = empresaRepository.obtenerEmpresaPorId(id);

        if (empresa != null) {
            System.out.println("Ingrese el nuevo nombre de la empresa:");
            String nombre = scanner.nextLine();
            empresa.setNombre(nombre);

            System.out.println("Ingrese la nueva industria de la empresa:");
            String industria = scanner.nextLine();
            empresa.setIndustria(industria);

            empresaRepository.guardarEmpresa(empresa);
            System.out.println("Empresa actualizada.");
        } else {
            System.out.println("Empresa no encontrada.");
        }
        System.out.println("Operación completada.");
    }

    public void eliminarEmpresa() {
        System.out.println("Ingrese el ID de la empresa:");
        int id = scanner.nextInt();
        scanner.nextLine();
        empresaRepository.eliminarEmpresa(id);
        System.out.println("Empresa eliminada.");
        System.out.println("Operación completada.");
    }

    public void mostrarEmpresa() {
        System.out.println("Ingrese el ID de la empresa:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Empresa empresa = empresaRepository.obtenerEmpresaPorId(id);

        if (empresa != null) {
            System.out.println("ID: " + empresa.getId());
            System.out.println("Nombre: " + empresa.getNombre());
            System.out.println("Industria: " + empresa.getIndustria());
        } else {
            System.out.println("Empresa no encontrada.");
        }
        System.out.println("Operación completada.");
    }

    public void cerrar() {
        empresaRepository.cerrar();
    }
}
