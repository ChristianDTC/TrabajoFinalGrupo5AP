import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
@AllArgsConstructor
@Setter
@Getter

public class Jugadores {

    private ArrayList<Persona> jugadores;

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


}