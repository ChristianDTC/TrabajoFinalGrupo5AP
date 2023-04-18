import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Jugadores {

    public ArrayList<Persona> jugadores;

    public Jugadores() {
        jugadores = new ArrayList<>();
    }

    public void cargarJugadores() throws IOException {
        Scanner lectorDesdeArchivo = new Scanner(Paths.get("src\\main\\resources\\personas.csv"));
        lectorDesdeArchivo.useDelimiter("[,;\\n\\r]+");

        while (lectorDesdeArchivo.hasNextInt()) {
            int dni = lectorDesdeArchivo.nextInt();
            String nom = lectorDesdeArchivo.next();
            String ape = lectorDesdeArchivo.next();
            Persona nuevaPersona = new Persona(dni, nom, ape);
            jugadores.add(nuevaPersona);
        }
    }

        public void calcularPuntaje(Torneo torneo , Juego juego) {

            for (Persona jugador : jugadores) {

                jugador.calcularPuntaje(torneo,juego);

            }

    }



}








