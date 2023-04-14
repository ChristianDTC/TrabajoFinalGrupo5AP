import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        Persona persona1 = new Persona(123, "Juan", "Espeche");
        Ronda ronda01 = new Ronda();
        PronDeRonda pronDeRonda01 = new PronDeRonda();

        ronda01.cargarRonda("resultados.csv");

        if (ronda01.getPartidos() == null) {
            System.out.println("Error: no se cargó ningún partido");
        }

        else System.out.println("Se cargaron " + ronda01.cantidadPartidos() + " partidos.");

        pronDeRonda01.cargarPronostico("pronostico.csv");

        if (pronDeRonda01.getPronosticos() == null) {
            System.out.println("Error: no se cargó ningún pronostico");
        }

        else System.out.println("Se cargaron " + pronDeRonda01.cantidadPartidos() + " pronosticos.");


        persona1.cargarPuntaje(ronda01,pronDeRonda01);
        System.out.println(persona1.getNombre() + " " + persona1.getApellido() + " tiene " + persona1.getPuntaje() + " puntos.");




    }
}