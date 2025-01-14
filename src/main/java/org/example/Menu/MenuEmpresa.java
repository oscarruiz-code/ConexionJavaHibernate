package org.example.Menu;

import org.example.Manejador.ManejadorEmpresa;

import java.util.Scanner;

/**
 * Clase para mostrar el menú CRUD de Empresa y gestionar la selección del usuario.
 *
 * @autor oscarruiz-code
 */
public class MenuEmpresa {

    private Scanner scanner;
    private ManejadorEmpresa manejadorEmpresa;

    public MenuEmpresa() {
        scanner = new Scanner(System.in);
        manejadorEmpresa = new ManejadorEmpresa();
    }

    public void mostrarMenuEmpresa() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar Empresa");
            System.out.println("2. Actualizar Empresa");
            System.out.println("3. Eliminar Empresa");
            System.out.println("4. Mostrar Empresa");
            System.out.println("5. Volver al Menú Principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                manejadorEmpresa.ingresarEmpresas();
            } else if (opcion == 2) {
                manejadorEmpresa.actualizarEmpresa();
            } else if (opcion == 3) {
                manejadorEmpresa.eliminarEmpresa();
            } else if (opcion == 4) {
                manejadorEmpresa.mostrarEmpresa();
            } else if (opcion == 5) {
                salir = true;
            } else {
                System.out.println("Elija una opción correcta.");
            }
        }
    }

    public void cerrar() {
        manejadorEmpresa.cerrar();
    }
}
