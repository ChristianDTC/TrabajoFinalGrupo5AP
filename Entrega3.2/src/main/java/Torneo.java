import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Torneo {
    public ArrayList<Fase> torneo;

    public Torneo() {
        torneo = new ArrayList<>();
    }

    public Fase getFase(int nroFase) {
        return torneo.get(nroFase - 1);          // Porque el índice comienza en 0 y las Fases desde 1
    }

    public int cantidadPartidos() {
        int cantPart = 0;
        for (Fase fase : torneo) {
            for (Ronda ronda : fase.fase) {
                cantPart += ronda.ronda.size();
            }
        }
        return cantPart;
    }

    public void cargarPartidos(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        Pattern regexLinea = Pattern.compile("(\\d{1,2})\\,(\\d{1,2})\\,([\\p{L1}]+)\\,([\\p{L1}]+)\\,(\\d{1,2})\\,(\\d{1,2})");

        int cantFase = 0;
        int cantRonda = 0;

        for (String linea : Files.readAllLines(archivo)) {                  //recorre todas las líneas del archivo

            Matcher matcher = regexLinea.matcher(linea);                    //somete las líneas a la expresión regular y las divide en grupos
            if (matcher.find()) {

                cantFase = Integer.parseInt(matcher.group(1));              //toma el último valor de "fase" para saber cuál es la cantidad de fases
                cantRonda = Integer.parseInt(matcher.group(2));             //toma el último valor de "fase" para saber cuál es la cantidad de fases
            }
        }

        int fase = 1;
        int ronda = 1;

        while (fase <= cantFase) {                                          //ciclo que se repite tantas veces como fases haya
            Fase nuevaFase = new Fase();
            while (ronda <= cantRonda) {                                    //ciclo que se repite tantas veces como rondas haya
                Ronda nuevaRonda = new Ronda();
                for (String linea : Files.readAllLines(archivo)) {          // itera todas las líneas
                    if (linea.contains(fase + "," + ronda + ",")) {         // busca todos los partidos de determinada fase y determinada ronda

                        Matcher matcher = regexLinea.matcher(linea);
                        matcher.find();                                                    //si no está, los .group() no compilan

                        String equipo1 = matcher.group(3);
                        String equipo2 = matcher.group(4);
                        int golesEquipo1 = Integer.parseInt(matcher.group(5));
                        int golesEquipo2 = Integer.parseInt(matcher.group(6));

                        Partido nuevoPartido = new Partido(fase, ronda, equipo1, equipo2, golesEquipo1, golesEquipo2);
                        nuevaRonda.agregarPartido(nuevoPartido);
                    }
                }
                nuevaFase.agregarRonda(nuevaRonda);
                ronda++;                                                // pasa a la siguiente ronda
            }
            torneo.add(nuevaFase);
            fase++;                                                     // pasa a la siguiente fase
            ronda = 1;                                                  // restablece el valor de las rondas
        }
    }

}