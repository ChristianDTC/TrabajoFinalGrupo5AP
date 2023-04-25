import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
@Getter@Setter
public class Boleta {


    private HashMap<String, PronDeRonda> boleta;

    public Boleta() {
        boleta = new HashMap<>();
    }

    public int cantidadBoletas(){ return boleta.size();}

    public Boleta(HashMap<String, PronDeRonda> boleta) {
        this.boleta = boleta;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "boleta=" + boleta +
                '}';
    }

    public void agregarPronRonda(Participantes p) throws SQLException, IOException {
        for (int i = 0; i < p.getPersonas().size(); i++) {

            PronDeRonda pron = new PronDeRonda();
            pron.cargarPronostico(p.getPersonas().get(i).getDni());
            boleta.put(p.getPersonas().get(i).getDni(), pron);
        }

    }

    public int todosLosPronosticos (){
        int total = 0 ;



            for (PronDeRonda ronda : boleta.values()) {

                total += ronda.getPronosticos().size();

            }
            return total;
    }




}