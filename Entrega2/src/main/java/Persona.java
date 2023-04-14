// Hace referncia al registro de una persona que juega al ProDe

import java.util.HashMap;

public class Persona {

    private int dni;
    private String nombre;
    private String apellido;
    private int puntaje = 0;


    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntaje() {
        return puntaje;
    }


    @Override
    public String toString() {
        return "DNI: " + dni + ", " + nombre + " " + apellido + ", tiene " + puntaje + " puntos. Contacto: ";
    }

    //   public void cargarPuntaje(Torneo torneo) {              // no terminado. salta error

    //   for (int i = 1; i <= torneo.cantidadRondas() ; i++)         //recorre todas las rondas del torneo

    // for (int j = 0; j < torneo.obtenerRonda(i).cantidadPartidos(); j++) {   //recorre todos los partidos
    //  if (torneo.obtenerRonda(i).consultarResultado(j) == obtenerPronRonda(i).contularResultado(j)) {
    //   puntaje ++; }
    //  }

}





