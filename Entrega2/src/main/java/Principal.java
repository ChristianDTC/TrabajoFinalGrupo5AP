import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Persona> jugadores = new ArrayList<>();   //  lista de personas que participan en el juego
        Torneo LigaConmebol = new Torneo();                 // Nuevo torneo instanciado
        Juego Prode = new Juego();                          // Juego Prode instanciado


        // carga de personas
        // pasar a clase JUGADORES (u otro nombre)
        Scanner lectorDesdeArchivo = new Scanner(Paths.get("src\\main\\resources\\personas.csv"));
        lectorDesdeArchivo.useDelimiter("[,;\\n\\r]+");

        while (lectorDesdeArchivo.hasNextInt()) {
            int dni = lectorDesdeArchivo.nextInt();
            String nom = lectorDesdeArchivo.next();
            String ape = lectorDesdeArchivo.next();
            Persona nuevaPersona = new Persona(dni, nom, ape);
            jugadores.add(nuevaPersona);
        }


        // carga de partidos
        LigaConmebol.cargarPartidos("resultados2.csv");

        if (LigaConmebol.cantidadPartidos() == 0) System.out.println("Error: no se cargaron los partidos \n");
        else System.out.println("Se cargaron " + LigaConmebol.cantidadPartidos() + " partidos. \n");


        // carga de pronósticos
        Prode.cargarPronosticos("pronosticos2.csv");

        if (Prode.cantidadPronosticos() == 0) System.out.println("Error: no se cargó ningún pronóstico");
        else System.out.println("Se cargaron " + Prode.cantidadPronosticos() + " pronósticos en total. \n");


        //calcula los puntajes de cada persona comparando los pronósticos con los resultados de los partidos
        for (Persona jugador : jugadores) {
            jugador.calcularPuntaje(LigaConmebol,Prode);
        }

        //muestra los jugadores con el puntaje obtenido
        for (Persona jugador : jugadores) {
            System.out.println(jugador);
        }




    }
}