package org.example.Menu;

import org.example.Manejador.ManejadorDepartamento;

import java.util.Scanner;

/**
 * Clase para mostrar el menú CRUD de Departamento y gestionar la selección del usuario.
 *
 * @autor oscarruiz-code
 */
public class MenuDepartamento {

    private Scanner scanner;
    private ManejadorDepartamento manejadorDepartamento;

    public MenuDepartamento() {
        scanner = new Scanner(System.in);
        manejadorDepartamento = new ManejadorDepartamento();
    }

    public void mostrarMenuDepartamento() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar Departamento");
            System.out.println("2. Actualizar Departamento");
            System.out.println("3. Eliminar Departamento");
            System.out.println("4. Mostrar Departamento");
            System.out.println("5. Volver al Menú Principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                manejadorDepartamento.ingresarDepartamentos();
            } else if (opcion == 2) {
                manejadorDepartamento.actualizarDepartamento();
            } else if (opcion == 3) {
                manejadorDepartamento.eliminarDepartamento();
            } else if (opcion == 4) {
                manejadorDepartamento.mostrarDepartamento();
            } else if (opcion == 5) {
                salir = true;
            } else {
                System.out.println("Elija una opción correcta.");
            }
        }
    }

    public void cerrar() {
        manejadorDepartamento.cerrar();
    }
}
