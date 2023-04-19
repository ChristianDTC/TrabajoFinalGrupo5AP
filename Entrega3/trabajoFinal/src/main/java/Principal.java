import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, SQLException {

        Torneo torneo = new Torneo();
        PronDeRonda pronDeRonda01 = new PronDeRonda();
        Boleta boletas = new Boleta();
        torneo.agregarRonda(1);
        torneo.agregarRonda(2);
        torneo.agregarRonda(3);
        boletas.agregarPronRonda("34211623");
        boletas.agregarPronRonda("33333333");
        if (torneo.getRondas().get(1).getPartidos() == null) {
            System.out.println("Error: no se cargó ningún partido");
        } else System.out.println("Se cargaron " + torneo.cantidadRondas() + " rondas.");
        System.out.println("Se cargaron " + boletas.cantidadBoletas() + " boletas.");
        System.out.println("Se cargaron " + torneo.getTodosLosPartidos(torneo).size() + " partidos.");
        System.out.println(boletas.getBoleta().get("33333333").getPronosticos());
        System.out.println(torneo.getRondas().get(1).getPartidos());
        System.out.println(torneo.getRondas().get(1).consultarResultado(1));
        int puntaje1 = boletas.cargarPuntaje(torneo,"33333333");
        System.out.println("el puntaje de la persona 2 es "+ puntaje1);
        int puntaje2 = boletas.cargarPuntaje(torneo,"34211623");
        System.out.println("el puntaje de la persona 1 es "+ puntaje2);







    }
}
