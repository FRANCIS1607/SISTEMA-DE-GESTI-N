import java.util.ArrayList;

public class GestorClientes {

    private ArrayList<Cliente> clientes;
    private int siguienteId;

    public GestorClientes() {
        clientes = new ArrayList<>();
        siguienteId = 1;
    }

    public void registrarCliente(String nombre, int edad, String ciudad) {

        Cliente cliente = new Cliente(
                siguienteId,
                nombre,
                edad,
                ciudad
        );

        clientes.add(cliente);
        siguienteId++;

        System.out.println("Cliente registrado correctamente.");
    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No existen clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("-------------------");
        }
    }

    public Cliente buscarPorId(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }

        }

        return null;
    }

    public ArrayList<Cliente> buscarPorCiudad(String ciudad) {

        ArrayList<Cliente> encontrados = new ArrayList<>();

        for (Cliente cliente : clientes) {

            if (cliente.getCiudad().equalsIgnoreCase(ciudad)) {
                encontrados.add(cliente);
            }

        }

        return encontrados;
    }

    public void ordenarPorEdad() {

        for (int i = 0; i < clientes.size() - 1; i++) {

            for (int j = 0; j < clientes.size() - 1 - i; j++) {

                if (clientes.get(j).getEdad() > clientes.get(j + 1).getEdad()) {

                    Cliente aux = clientes.get(j);

                    clientes.set(j, clientes.get(j + 1));

                    clientes.set(j + 1, aux);
                }
            }
        }

        System.out.println("Clientes ordenados por edad.");
    }
}