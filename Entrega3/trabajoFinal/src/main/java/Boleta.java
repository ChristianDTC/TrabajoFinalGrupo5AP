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

    public void agregarPronRonda(String nombre) throws SQLException, IOException {

        PronDeRonda pron = new PronDeRonda();
        pron.cargarPronostico(nombre);
        boleta.put(nombre, pron);
    }

    public int todosLosPronosticos (){
        int total = 0 ;



            for (PronDeRonda ronda : boleta.values()) {

                total += ronda.getPronosticos().size();

            }
            return total;
    }

    public void cargarPuntaje(Torneo torneo, String nombre) {
        int puntaje = 0;
        for (int i = 0; i < torneo.getTodosLosPartidos().size(); i++) {

            if (torneo.getTodosLosPartidos().get(i).getResultado() == boleta.get(nombre).consultarResultado(i))
                puntaje++;
        }
            boleta.get(nombre).setPuntaje(puntaje);
    }
    public void getAcertados(Torneo torneo, String nombre) {
        int puntaje = 0;
        for (int i = 0; i < torneo.getTodosLosPartidos().size(); i++) {

            if (torneo.getTodosLosPartidos().get(i).getResultado() == boleta.get(nombre).consultarResultado(i))
                puntaje++;
        }
        boleta.get(nombre).setPronosticosAcertados(puntaje);
    }

}