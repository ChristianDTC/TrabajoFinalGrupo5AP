import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, SQLException {

        Torneo torneo = new Torneo();
        Boleta boletas = new Boleta();
        Participantes participantes = new Participantes();
        torneo.agregarRonda(1);
        torneo.agregarRonda(2);
        torneo.agregarRonda(3);
        boletas.agregarPronRonda("34211623");
        boletas.agregarPronRonda("33333333");
        boletas.agregarPronRonda("45612345");
        participantes.cargarPersonas();
        if (torneo.getRondas().get(0).getPartidos() == null) {
            System.out.println("Error: no se cargó ningún partido");
        } else System.out.println("Se cargaron " + torneo.cantidadRondas() + " rondas.");
        System.out.println("Se cargaron " + boletas.cantidadBoletas() + " boletas.");
        System.out.println("Se cargaron " + torneo.getTodosLosPartidos().size() + " partidos.");
        System.out.println("Se cargaron " + boletas.todosLosPronosticos() + " pronosticos.");
        System.out.println("Participaron " + participantes.getPersonas().size() + " personas");
        participantes.cargarPuntaje(torneo, boletas);
        System.out.println(participantes.getPersonas());
        System.out.println(boletas.getBoleta().get(participantes.getPersonas().get(1).getDni()).getPuntaje());








    }
}
