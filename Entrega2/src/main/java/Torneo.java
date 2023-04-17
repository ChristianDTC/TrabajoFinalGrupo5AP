import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Torneo {
    public ArrayList<Partido> partidos;

    public Torneo() {
        partidos = new ArrayList<>();
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarPartido(Partido nuevo) {
        partidos.add(nuevo);
    }

    public Resultado consultarResultado(int indice) {
        return partidos.get(indice).getResultado();
    }

    public int cantidadPartidos() {
        return partidos.size();
    }


    public void cargarPartidos(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n\\r]+");

            lectorDesdeArchivo.nextLine();                               //Saltea la primera línea, contiene nombre de los campos de atributos

            Pattern regexLinea = Pattern.compile("(\\d{1,2})\\,([a-zA-Z áéíóúÁÉÍÓÚ]+)\\,([a-zA-Z ú]+)\\,(\\d{1,2})\\,(\\d{1,2})");
            //expresión regular: 1 o 2 números + "," + letras + "," + letras + "," + 1 o 2 números + "," + 1 o 2 números

            while (lectorDesdeArchivo.hasNextInt()) {

                Matcher linea = regexLinea.matcher(lectorDesdeArchivo.nextLine());
                linea.find();                                                    //si no está, los .group() no compilan

                int nroRonda = Integer.parseInt(linea.group(1));
                String equipo1 = linea.group(2);
                String equipo2 = linea.group(3);
                int golesEquipo1 = Integer.parseInt(linea.group(4));
                int golesEquipo2 = Integer.parseInt(linea.group(5));

                Partido nuevoPartido = new Partido(nroRonda, equipo1, equipo2, golesEquipo1, golesEquipo2);
                agregarPartido(nuevoPartido);

            }

            lectorDesdeArchivo.close();
        }

        else System.out.println("Error: no se encontró el archivo \n");
    }




}

