public class Partido {

    private int nroRonda;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private final Resultado resultado;

    public Partido(int nroRonda, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.nroRonda = nroRonda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        if (golesEquipo1 - golesEquipo2 == 0) resultado = Resultado.EMPATE;
        else if (golesEquipo1 - golesEquipo2 > 0) resultado = Resultado.GANO1;
        else resultado = Resultado.GANO2;
    }

    public int getNroRonda() {
        return nroRonda;
    }

    public void setNroRonda(int nroRonda) {
        this.nroRonda = nroRonda;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }


    public Resultado getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return equipo1 + ": " + golesEquipo1 + " - " + equipo2 + ": " + golesEquipo2 + "\t\t" +
                "Ronda " + nroRonda + "\tResultado: " + resultado;
    }

}