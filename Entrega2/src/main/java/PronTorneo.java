// Pronosticos de todo el torneo hechos por una persona

import java.util.HashMap;

public class PronTorneo {
    public HashMap<Integer, Carton> pronPersona;

    public PronTorneo() {
        pronPersona = new HashMap<>();
    }

    public int cantidadPronRondas() {return pronPersona.size();
    }

    public Carton obtenerCarton(int nroRonda) {
        return pronPersona.get(nroRonda);
    }

    public void agregarPronRonda(int nroRonda, Carton carton) {
        pronPersona.put(nroRonda, carton);
    }








}