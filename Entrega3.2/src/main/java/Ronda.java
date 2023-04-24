import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Setter
@Getter

public class Ronda {

    public ArrayList<Partido> ronda;

    public Ronda() {
        ronda = new ArrayList<>();
    }

    public void agregarPartido(Partido nuevo){
        ronda.add(nuevo);
    }

    public Partido getPartido(String equipo1, String equipo2) {
        for (Partido partido : ronda) {
            if (partido.getEquipo1().equals(equipo1) && partido.getEquipo2().equals(equipo2)) return partido;
        }
        return null;
    }

}