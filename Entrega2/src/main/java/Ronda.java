import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ronda {
    public ArrayList<Partido> partidos;

    public Ronda() {
        partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarPartido(Partido nuevo) {
        partidos.add(nuevo);
    }

    public Resultado consultarResultado(int i) {
        return partidos.get(i).getResultado();
    }

    public int cantidadPartidos() {
        return partidos.size();
    }


}

