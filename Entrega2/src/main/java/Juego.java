import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Juego {
    public ArrayList<Pronostico> juego;
    public Juego() {juego = new ArrayList<>();
    }

    public Pronostico get(int indice) {
        return juego.get(indice);
    }
    public Resultado consultarResultado(int indice) {
        return juego.get(indice).getResultado();
    }

    public void agregarPronostico(Pronostico pronostico){
        juego.add(pronostico);
    }

    public int cantidadPronosticos() {
        return juego.size();
    }

    public void cargarPronosticos(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n]");

            lectorDesdeArchivo.nextLine();     //Salteo primera línea, contiene nombre de los campos de atributos

            while (lectorDesdeArchivo.hasNext()) {

                int dni = lectorDesdeArchivo.nextInt();
                int nroRonda = lectorDesdeArchivo.nextInt();
                String equipo1 = lectorDesdeArchivo.next();
                String equipo2 = lectorDesdeArchivo.next();

                Resultado resultado = null;
                if (!lectorDesdeArchivo.next().isBlank())
                    resultado = Resultado.GANO1;
                if (!lectorDesdeArchivo.next().isBlank())
                    resultado = Resultado.GANO2;
                if (!lectorDesdeArchivo.next().isBlank())
                    resultado = Resultado.EMPATE;

                Pronostico nuevoPronostico = new Pronostico(dni, nroRonda, equipo1, equipo2, resultado);
                agregarPronostico(nuevoPronostico);

            }

            lectorDesdeArchivo.close();

        }

        else System.out.println("Error: no se encontró el archivo. \n");

    }


}

