import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter

public class Fase {

    public ArrayList<Ronda> fase;
    public Fase(){
        fase = new ArrayList<>();
    }

    public Ronda getRonda(int nroRonda) {
        return fase.get(nroRonda - 1);          // Porque el índice comienza en 0 y las Fases desde 1
    }

    public void agregarRonda(Ronda nueva) {
        fase.add(nueva);
    }

}