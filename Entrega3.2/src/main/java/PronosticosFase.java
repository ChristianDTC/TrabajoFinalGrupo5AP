import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
@Getter
@Setter

public class PronosticosFase {
    public ArrayList<Boleta> pronosticosFase;

    public PronosticosFase() {
        pronosticosFase = new ArrayList<>();
    }

    public void agregarPronostico(Boleta nuevo){
        pronosticosFase.add(nuevo);
    }

    public ArrayList<Boleta> iterar() {
        return pronosticosFase;
    }

    public int cantidadPronosticos() {
        int cant = 0;
        for (Boleta boleta : pronosticosFase) {
           cant += boleta.cantidadPronosticos();
        }
        return cant;
    }

    public boolean bonus(){
        for (Boleta boleta : pronosticosFase) {
            if (!boleta.bonus())            // si al menos el bonus de una boleta es falso, retorna falso el bonus de la fase
                return false;
        }
        return true;
    }




}