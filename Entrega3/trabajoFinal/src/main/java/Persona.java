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
        return "Persona{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }

    public void cargarPuntaje(Ronda ronda, PronDeRonda pronDeRonda) {

        for (int i = 0; i < ronda.cantidadPartidos() ; i++) {

            if (ronda.consultarResultado(i) == pronDeRonda.consultarResultado(i)) {
                puntaje ++; }
        }
    }



}