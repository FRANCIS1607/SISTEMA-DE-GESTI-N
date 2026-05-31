import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestorClientes gestor = new GestorClientes();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE GESTIÓN DE CLIENTES =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Buscar cliente por ID");
            System.out.println("3. Buscar clientes por ciudad");
            System.out.println("4. Ordenar clientes por edad");
            System.out.println("5. Mostrar clientes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    if (nombre.isBlank()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    if (edad <= 0) {
                        System.out.println("La edad debe ser mayor a cero.");
                        break;
                    }

                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();

                    if (ciudad.isBlank()) {
                        System.out.println("La ciudad no puede estar vacía.");
                        break;
                    }

                    gestor.registrarCliente(nombre, edad, ciudad);

                    break;

                case 2:

                    System.out.print("Ingrese el ID: ");
                    int id = scanner.nextInt();

                    Cliente cliente = gestor.buscarPorId(id);

                    if (cliente != null) {
                        System.out.println(cliente);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Ingrese la ciudad: ");
                    String ciudadBusqueda = scanner.nextLine();

                    ArrayList<Cliente> encontrados =
                            gestor.buscarPorCiudad(ciudadBusqueda);

                    if (encontrados.isEmpty()) {

                        System.out.println("No existen clientes en esa ciudad.");

                    } else {

                        for (Cliente c : encontrados) {
                            System.out.println(c);
                            System.out.println("-------------------");
                        }

                    }

                    break;

                case 4:

                    gestor.ordenarPorEdad();

                    break;

                case 5:

                    gestor.mostrarClientes();

                    break;

                case 6:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}