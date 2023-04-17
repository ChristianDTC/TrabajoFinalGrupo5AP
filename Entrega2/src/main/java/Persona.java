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

    public int getAciertos() {
        return aciertos;
    }

    public void calcularPuntaje(Torneo torneo , Juego juego) {

        int indiceTorneo = 0;

        for (int i = 0; i < juego.cantidadPronosticos(); i++) {

            if (juego.get(i).getDni() == this.dni) {

                if (juego.consultarResultado(i) == torneo.consultarResultado(indiceTorneo)) {
                    puntaje++;
                    aciertos++;
                }

                indiceTorneo++;
            }
        }
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " ,DNI: " + dni + ", tiene " + puntaje + " puntos y acertó " + aciertos + " pronósticos.";
    }


}