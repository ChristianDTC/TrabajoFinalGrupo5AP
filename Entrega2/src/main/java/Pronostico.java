public class Pronostico {

    private int dni;
    private int nroRonda;
    private String equpo1;
    private String equipo2;
    private Resultado resultado;       // EMPATE, GANO1, GANO2

    public Pronostico(int dni, int nroRonda, String equpo1, String equipo2, Resultado resultado) {
        this.dni = dni;
        this.nroRonda = nroRonda;
        this.equpo1 = equpo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public String getEqupo1() {
        return equpo1;
    }

    public void setEqupo1(String equpo1) {
        this.equpo1 = equpo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        return "DNI: " + dni + "\t Ronda: " + nroRonda + "\t" + equpo1 + " vs " + equipo2 + " - resultado: " + resultado;
    }



}



