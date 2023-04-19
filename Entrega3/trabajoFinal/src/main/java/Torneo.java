import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
@Getter@Setter
public class Torneo {

    private ArrayList<Ronda> rondas;
    public Torneo() {
        rondas = new ArrayList<>();
    }
    public int cantidadRondas(){ return rondas.size();}

    public void agregarRonda(int i) throws SQLException, IOException {

        Ronda ronda = new Ronda();
        ronda.cargarPartido(i);
        rondas.add(ronda);
    }
    public ArrayList<Partido> getTodosLosPartidos (){
        ArrayList<Partido> r = new ArrayList<>();
        for (int i = 0; i < rondas.size(); i++) {
            for (int j = 0; j < rondas.get(i).cantidadPartidos(); j++) {
                r.add(rondas.get(i).getPartidos().get(j));
            }
        } return r;

    }


}
