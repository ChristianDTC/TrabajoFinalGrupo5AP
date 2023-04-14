import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList con los pronosticos de una persona.
//Pregunta: El ArrayList no se declara sino hasta que se comprueba que el archivo existe. ¿Está bien o es mejor declarla al comienzo

public class Ronda {
    public ArrayList<Partido> partidos;

    public Ronda() {
        partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public Resultado consultarResultado(int i){
        return partidos.get(i).getResultado();
    }

    public int cantidadPartidos() {
        return partidos.size();
    }

    // El archivo csv debe estar guardado en la carpeta "resources"
    public void cargarRonda(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n\\r]");

            while (lectorDesdeArchivo.hasNext()) {

                String equipo1 = lectorDesdeArchivo.next();
                String equipo2 = lectorDesdeArchivo.next();
                int golesEquipo1 = lectorDesdeArchivo.nextInt();
                int golesEquipo2 = lectorDesdeArchivo.nextInt();

                Partido nuevo = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);
                partidos.add(nuevo);
            }

            lectorDesdeArchivo.close();
        }
        else System.out.println("Error: no se encontró el archivo");

    }
}




