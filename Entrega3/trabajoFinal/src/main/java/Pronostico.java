import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Pronostico {

    private String equipo1;
    private String equipo2;

    private Resultado resultado;       // EMPATE, GANO1, GANO2
    private String participante;




    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString() {
        return equipo1 + " vs " + equipo2 + " - resultado: " + resultado + "- participante: " + participante;
    }


}

