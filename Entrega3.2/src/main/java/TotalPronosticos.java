import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor

public class TotalPronosticos {

    public ArrayList<PronosticosFase> totalPronosticos;

    public TotalPronosticos() {
        totalPronosticos = new ArrayList<>();
    }

    public ArrayList<PronosticosFase> iterar(){
        return totalPronosticos;
    }

    public void agregarPronostico(PronosticosFase pronosticosFase){
      totalPronosticos.add(pronosticosFase);
    }

    public int cantidadPronosticos(){
        int cant = 0;
        for (PronosticosFase totalPronostico : totalPronosticos) {
            cant += totalPronostico.cantidadPronosticos();
        }
        return cant;
    }
}