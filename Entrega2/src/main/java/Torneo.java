import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;



public class Torneo {           // DUDA: public o private?
    public HashMap<Integer , Ronda> torneo;

    public Torneo() {
        torneo = new HashMap<>();
    }

    public int cantidadRondas() {
        return torneo.size();
    }

    public Ronda obtenerRonda(int nroRonda) {return torneo.get(nroRonda);}


    public void cargarPartidos(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n\\r]");

            lectorDesdeArchivo.nextLine();     //Primera línea contiene nombre de los campos de atributos

            int nroRonda = lectorDesdeArchivo.nextInt();

            while (true) {
                Ronda nuevaRonda = new Ronda();
               // nuevaRonda.cargarRonda(archivoCSV, nroRonda);
                torneo.put(nroRonda, nuevaRonda);
                int cantidadDeRondas = nuevaRonda.cantidadPartidos() * 2 - 1;

                nroRonda++;

                if (nroRonda > cantidadDeRondas) break;
            }

            lectorDesdeArchivo.close();
        }

        else System.out.println("Error: no se encontró el archivo \n");
    }
    }


