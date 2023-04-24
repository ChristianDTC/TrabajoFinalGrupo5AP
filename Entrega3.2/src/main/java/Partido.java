import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class Partido {

    private int fase;
    private int ronda;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private final Resultado resultado;

    public Partido(int fase, int ronda, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.fase = fase;
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        if (golesEquipo1 - golesEquipo2 == 0) resultado = Resultado.EMPATE;
        else if (golesEquipo1 - golesEquipo2 > 0) resultado = Resultado.GANO1;
        else resultado = Resultado.GANO2;
    }

    @Override
    public String toString() {
        return equipo1 + ": " + golesEquipo1 + " - " + equipo2 + ": " + golesEquipo2 + "\t\t" +
                "\tResultado: " + resultado;
    }

}