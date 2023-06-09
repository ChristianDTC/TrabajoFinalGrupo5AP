import lombok.Getter;
import lombok.Setter;

import java.sql.*;
@Getter@Setter
public class Persona {

    private String dni;
    private String nombre;
    private String apellido;
    private int puntaje = 0;

    public Persona(String nombre, String apellido, String dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }




    @Override
    public String toString() {
        return "Persona{" +
                "\n DNI=" + dni +
                "\n NOMBRE='" + nombre + '\'' +
                "\n APELLIDO='" + apellido + '\'' +
                "\n PUNTAJE=" + puntaje +
                '}'+"\n\n" ;
    }


    }



