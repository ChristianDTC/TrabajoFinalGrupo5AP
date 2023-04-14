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
        Scanner lectorDesdeArchivo = new Scanner(Paths.get("src\\main\\resources\\personas.csv"));
        lectorDesdeArchivo.useDelimiter("[,;\\n\\r]+");

        while (lectorDesdeArchivo.hasNextInt()) {
            int dni = lectorDesdeArchivo.nextInt();
            String nom = lectorDesdeArchivo.next();
            String ape = lectorDesdeArchivo.next();
            Persona nuevaPersona = new Persona(dni,nom,ape);
            jugadores.add(nuevaPersona);
           // if (lectorDesdeArchivo.hasNext()) lectorDesdeArchivo.next();        // tengo que ponerlo para que no se trabe
        }


        // carga de partidos
        //LigaConmebol.cargarPartidos("resultados2.csv");

        if (LigaConmebol == null) System.out.println("Error: no se cargaron los partidos \n");
        else System.out.println("Se cargaron " + LigaConmebol.cantidadRondas() + " rondas. \n");


        // carga de pronosticos
       Prode.cargarPronosticos("pronosticos2.csv");

        if (Prode == null) System.out.println("Error: no se cargó ningún pronóstico");
        else System.out.println("Se cargaron los pronósticos de " + Prode.cantidadJugadores()+ " jugadores.");









    }
}