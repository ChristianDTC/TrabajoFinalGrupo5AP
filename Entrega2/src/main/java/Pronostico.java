// Es el pronostico de UN partido

public class Pronostico {

    private String equpo1;
    private String equipo2;
    private Resultado resultado;       // EMPATE, GANO1, GANO2

    public Pronostico(String equpo1, String equipo2, Resultado resultado) {
        this.equpo1 = equpo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
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
        return equpo1 + " vs " + equipo2 + " - resultado: " + resultado;
    }



}



