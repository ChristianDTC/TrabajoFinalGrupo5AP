import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PronDeRonda {
    public ArrayList<Pronostico> pronosticos;

    public PronDeRonda() {
        pronosticos = new ArrayList<>();
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public Resultado contularResultado(int i) {
        return pronosticos.get(i).getResultado();
    }

    public int cantidadPartidos() {
        return pronosticos.size();
    }

    // El archivo csv debe estar guardado en la carpeta "resources"
    public void cargarPronostico(String ArchivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + ArchivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n\\r]");

            while (lectorDesdeArchivo.hasNext()) {
                String equipo1 = lectorDesdeArchivo.next();
                String equipo2 = lectorDesdeArchivo.next();
                Resultado resultado = null;

                if (!lectorDesdeArchivo.next().isBlank()) {
                    resultado = Resultado.GANO1;
                }

                if (!lectorDesdeArchivo.next().isBlank()) {
                    resultado = Resultado.GANO2;
                }

                if (!lectorDesdeArchivo.next().isBlank()) {
                    resultado = Resultado.EMPATE;
                }
                Pronostico nuevo = new Pronostico(equipo1, equipo2, resultado);
                pronosticos.add(nuevo);
            }

            lectorDesdeArchivo.close();

        } else System.out.println("Error: No se encontró el archivo");
    }



}





