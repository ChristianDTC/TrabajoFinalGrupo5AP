import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter

public class Boleta {

    public ArrayList<Pronostico> pronosticosRonda;

    public Boleta() {
        pronosticosRonda = new ArrayList<>();
    }

    public void agregarPronostico(Pronostico nuevo){
        pronosticosRonda.add(nuevo);
    }

    public ArrayList<Pronostico> iterar(){
        return pronosticosRonda;
    }

    public int cantidadPronosticos(){
        return pronosticosRonda.size();
    }

    public boolean bonus() {
        for (Pronostico pronostico : pronosticosRonda) {
            if (!pronostico.isAcierto())
                return false;
        }
        return true;
    }


}