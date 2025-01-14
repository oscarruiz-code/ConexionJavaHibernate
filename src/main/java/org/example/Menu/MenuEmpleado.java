package org.example.Menu;

import org.example.Manejador.ManejadorEmpleado;

import java.util.Scanner;

/**
 * Clase para mostrar el menú CRUD de Empleado y gestionar la selección del usuario.
 *
 * @autor oscarruiz-code
 */
public class MenuEmpleado {

    private Scanner scanner;
    private ManejadorEmpleado manejadorEmpleado;

    public MenuEmpleado() {
        scanner = new Scanner(System.in);
        manejadorEmpleado = new ManejadorEmpleado();
    }

    public void mostrarMenuEmpleado() {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar Empleado");
            System.out.println("2. Actualizar Empleado");
            System.out.println("3. Eliminar Empleado");
            System.out.println("4. Mostrar Empleado");
            System.out.println("5. Volver al Menú Principal");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                manejadorEmpleado.ingresarEmpleados();
            } else if (opcion == 2) {
                manejadorEmpleado.actualizarEmpleado();
            } else if (opcion == 3) {
                manejadorEmpleado.eliminarEmpleado();
            } else if (opcion == 4) {
                manejadorEmpleado.mostrarEmpleado();
            } else if (opcion == 5) {
                salir = true;
            } else {
                System.out.println("Elija una opción correcta.");
            }
        }
    }

    public void cerrar() {
        manejadorEmpleado.cerrar();
    }
}
