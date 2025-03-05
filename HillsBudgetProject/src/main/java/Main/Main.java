package Main;

import Controllers.AprobacionController;
import Controllers.PresupuestoGeneralController;
import Controllers.UsuarioController;
import Models.Usuario;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        // Controladores
        UsuarioController usuarioController = new UsuarioController();
        PresupuestoGeneralController presupuestoGeneralController = new PresupuestoGeneralController();
        AprobacionController aprobacionController = new AprobacionController();

        do {
            System.out.println("GESTOR DE PRESUPUESTOS");
            System.out.println();
            System.out.println("1. Usuario");
            System.out.println("2. PresupuestoGeneral");
            System.out.println("3. Aprobacion");
            System.out.println("0. Salir del CRUD");
            System.out.println();
            System.out.print("Elija una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    // Variables para el usuario
                    int id;
                    String nombre, email, rol;

                    System.out.println("Por favor ingrese el ID del usuario:");
                    id = leer.nextInt();
                    leer.nextLine(); // Limpiar el buffer

                    System.out.println("Por favor ingrese el nombre del usuario:");
                    nombre = leer.nextLine();

                    System.out.println("Por favor ingrese el correo del usuario:");
                    email = leer.nextLine();

                    System.out.println("Por favor ingrese el rol del usuario:");
                    rol = leer.nextLine();

                    Usuario usuario = new Usuario(id, nombre, email, rol);
                    usuarioController.agregarUsuario(usuario);

                    break;

                case 2:
                    // Aquí puedes agregar la lógica para PresupuestoGeneral
                    System.out.println("Funcionalidad de PresupuestoGeneral en construcción...");
                    break;

                case 3:
                    // Aquí puedes agregar la lógica para Aprobacion
                    System.out.println("Funcionalidad de Aprobacion en construcción...");
                    break;

                case 0:
                    System.out.println("Saliendo del CRUD...");
                    break;

                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        leer.close(); // Cerrar el Scanner para evitar fugas de memoria
    }
}
