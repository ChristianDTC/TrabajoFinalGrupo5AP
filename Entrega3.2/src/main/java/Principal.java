import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws IOException, SQLException {

        Jugadores jugadores = new Jugadores();              // Lista de personas que participan en el juego
        Torneo LigaConmebol = new Torneo();                 // Nuevo torneo instanciado
        Juego Prode = new Juego();                          // Juego Prode instanciado

        // carga configuraciones preestablecidas en un archivo JSON
        ObjectMapper om = new ObjectMapper();
        Configuracion cfg;
        cfg = om.readValue(new File("src\\main\\resources\\config.json"), Configuracion.class);

        // carga lista de personas que participan en el juego
        jugadores.cargarJugadores();

        // carga de partidos
        LigaConmebol.cargarPartidos("resultados3.csv");


        if (LigaConmebol.cantidadPartidos() == 0) System.out.println("Error: no se cargaron los partidos \n");
        else System.out.println("Se cargaron " + LigaConmebol.cantidadPartidos() + " partidos. \n");

        // carga de pronósticos
        Prode.cargarPronosticosDB(cfg,jugadores);

        if (Prode.cantidadPronosticos() == 0) System.out.println("Error: no se cargó ningún pronóstico");
        else System.out.println("Se cargaron " + Prode.cantidadPronosticos() + " pronósticos en total. \n");


        //calcula los aciertos y puntajes de cada persona
        Prode.calcularPuntaje(jugadores,LigaConmebol,cfg);

        //muestra los jugadores con el puntaje obtenido
        for (Persona jugador : jugadores.getJugadores()) {
            System.out.println(jugador);
        }



    }
}