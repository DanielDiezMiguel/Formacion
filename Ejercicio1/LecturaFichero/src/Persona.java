import java.util.Optional;
import java.util.function.Supplier;

public class Persona {
    protected String nombre;
    protected String poblacion;
    protected String edad;

    public Persona(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public Persona(){}

    public Optional<String> getNombre() {
        return Optional.ofNullable(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Optional<String> getPoblacion() {
        return Optional.ofNullable(poblacion);
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Optional<String> getEdad() {
        return Optional.ofNullable(edad);
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String rellenarPersona() {
        return "Nombre: " + this.getNombre() + ". Población: " + this.getPoblacion() + ". Edad: " + this.getEdad();
    }

}
