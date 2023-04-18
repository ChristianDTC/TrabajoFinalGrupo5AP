import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        Jugadores jugadores = new Jugadores();              //  lista de personas que participan en el juego
        Torneo LigaConmebol = new Torneo();                 // Nuevo torneo instanciado
        Juego Prode = new Juego();                          // Juego Prode instanciado


        // carga de personas
        jugadores.cargarJugadores();


        // carga de partidos
        LigaConmebol.cargarPartidos("resultados2.csv");

        if (LigaConmebol.cantidadPartidos() == 0) System.out.println("Error: no se cargaron los partidos \n");
        else System.out.println("Se cargaron " + LigaConmebol.cantidadPartidos() + " partidos. \n");


        // carga de pronósticos
        Prode.cargarPronosticos("pronosticos2.csv");

        if (Prode.cantidadPronosticos() == 0) System.out.println("Error: no se cargó ningún pronóstico");
        else System.out.println("Se cargaron " + Prode.cantidadPronosticos() + " pronósticos en total. \n");


        //calcula los puntajes de cada persona comparando los pronósticos con los resultados de los partidos
        jugadores.calcularPuntaje(LigaConmebol,Prode);


        //muestra los jugadores con el puntaje obtenido
        for (Persona jugador : jugadores.jugadores) {
            System.out.println(jugador);
        }




    }
}