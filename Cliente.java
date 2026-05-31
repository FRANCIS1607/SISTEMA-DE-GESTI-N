public class Cliente {

    private int id;
    private String nombre;
    private int edad;
    private String ciudad;

    public Cliente(int id, String nombre, int edad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nCiudad: " + ciudad;
    }
}