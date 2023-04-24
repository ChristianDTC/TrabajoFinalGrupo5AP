import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Pronostico {

    private int dni;
    private int nroFase;
    private int nroRonda;
    private String equpo1;
    private String equipo2;
    private Resultado resultado;       // EMPATE, GANO1, GANO2, NA
    private boolean acierto;

    public Pronostico(int dni, int nroFase, int nroRonda, String equpo1, String equipo2, Resultado resultado) {
        this.dni = dni;
        this.nroFase = nroFase;
        this.nroRonda = nroRonda;
        this.equpo1 = equpo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\t Fase: " + nroFase + "\t Ronda: " + nroRonda + "\t" + equpo1 + " vs " + equipo2 + " - resultado: " + resultado;
    }

    public void acierto(Torneo torneo, Persona persona){
        if (this.resultado.equals
                (torneo.getFase(this.nroFase).getRonda(this.nroRonda).getPartido(this.equpo1,this.equipo2).getResultado()))
        {
            this.acierto = true;
            persona.setAciertos(persona.getAciertos()+1);
        }
        else this.acierto = false;
    }
}