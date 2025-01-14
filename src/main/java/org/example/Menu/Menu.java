package org.example.Menu;

import java.util.Scanner;

/**
 * Clase para mostrar el menú principal y gestionar la selección del usuario.
 *
 * @autor oscarruiz-code
 */
public class Menu {

    private Scanner scanner;
    private MenuEmpresa menuEmpresa;
    private MenuDepartamento menuDepartamento;
    private MenuEmpleado menuEmpleado;

    public Menu() {
        scanner = new Scanner(System.in);
        menuEmpresa = new MenuEmpresa();
        menuDepartamento = new MenuDepartamento();
        menuEmpleado = new MenuEmpleado();
    }

    /**
     * Método para mostrar el menú principal y gestionar la selección del usuario.
     */
    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Opciones de Empresa");
            System.out.println("2. Opciones de Departamento");
            System.out.println("3. Opciones de Empleado");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                menuEmpresa.mostrarMenuEmpresa();
            } else if (opcion == 2) {
                menuDepartamento.mostrarMenuDepartamento();
            } else if (opcion == 3) {
                menuEmpleado.mostrarMenuEmpleado();
            } else if (opcion == 4) {
                salir = true;
                cerrarmanejadores();
                System.out.println("Finalizado");
            } else {
                System.out.println("Elija una opción correcta.");
            }
        }
    }

    /**
     * Método para cerrar los recursos de los manejadores.
     */
    private void cerrarmanejadores() {
        menuEmpresa.cerrar();
        menuDepartamento.cerrar();
        menuEmpleado.cerrar();
    }
}
