// Cambiar nombre a CARTON para evitar confuciones con los nombres
//

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Carton {
    public ArrayList<Pronostico> carton;

    public Carton() { carton = new ArrayList<>();}

    public ArrayList<Pronostico> obtenerPronosticos() {
        return carton;
    }

    public void setCarton(ArrayList<Pronostico> carton) {
        this.carton = carton;
    }

    public void agregarPronostico(Pronostico nuevo) {
        carton.add(nuevo);
    }

    public Resultado contularResultado(int i) {
        return carton.get(i).getResultado();
    }

    public int cantidadPronosticos(){
        return carton.size();
    }

    public void borrarCarton() {carton.clear();}




}





