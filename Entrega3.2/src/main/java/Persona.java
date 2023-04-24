import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Persona {

    private int dni;
    private String nombre;
    private String apellido;

    private int puntaje = 0;
    private int aciertos = 0;


    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + ", DNI: " + dni + ", tiene " + puntaje + " puntos y acertó " + aciertos + " pronósticos.";
    }

}