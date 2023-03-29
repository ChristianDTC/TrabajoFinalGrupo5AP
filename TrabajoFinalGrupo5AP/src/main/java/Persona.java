public class Persona {

    private int dni;
    private String nombre;
    private String apellido;
    private String contacto;

    public Persona(int dni, String nombre, String apellido, String contacto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
