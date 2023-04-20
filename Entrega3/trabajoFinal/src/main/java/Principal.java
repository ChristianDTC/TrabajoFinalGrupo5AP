import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, SQLException {

        Torneo torneo = new Torneo();
        Boleta boletas = new Boleta();
        Participantes participantes = new Participantes();
        torneo.agregarRondas(3);
        participantes.cargarPersonas();
        boletas.agregarPronRonda(participantes);


        if (torneo.getRondas().get(0).getPartidos() == null) {
            System.out.println("Error: no se cargó ningún partido");
        } else System.out.println("Se cargaron " + torneo.cantidadRondas() + " rondas.");
        System.out.println("Se cargaron " + boletas.cantidadBoletas() + " boletas.");
        System.out.println("Se cargaron " + torneo.getTodosLosPartidos().size() + " partidos.");
        System.out.println("Se cargaron " + boletas.todosLosPronosticos() + " pronosticos.");
        System.out.println("Participaron " + participantes.getPersonas().size() + " personas");
        participantes.cargarPuntaje(torneo, boletas);
        System.out.println(participantes.getPersonas());









    }
}
