import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Juego {
    public HashMap<Integer,PronTorneo> jugadores;          // Key = dni

    public Juego() {jugadores = new HashMap<>();
    }

    public PronTorneo obtenerJugador(int dni) {
        return jugadores.get(dni);
    }

    public void agregarJugador(Integer dni , PronTorneo pronTorneo) {
        jugadores.put(dni, pronTorneo);
    }

    public int cantidadJugadores() {
        return jugadores.size();
    }

    public int cantidadTotalPronosticos() {

        int cantidad = 0;
        for (PronTorneo value : jugadores.values()) {
            for (int i = 0; i < value.cantidadPronRondas(); i++) {

                cantidad += value.obtenerCarton(i+1).cantidadPronosticos();     // debería crear un metodo en PronTorneo equivalente a HashMap.value y reemplazar "obtenerCarton"
            }
        }
        return cantidad;
    }


    public void cargarPronosticos(String archivoCSV) throws IOException {
        String carpetaResources = "src\\main\\resources\\";
        Path archivo = Paths.get(carpetaResources + archivoCSV);

        if (Files.exists(archivo)) {

            Scanner lectorDesdeArchivo = new Scanner(archivo);
            lectorDesdeArchivo.useDelimiter("[,;\\n]");

            lectorDesdeArchivo.nextLine();     //Primera línea contiene nombre de los campos de atributos

            PronTorneo pronosticoDeUnaPersona = new PronTorneo();

            int dniControl = lectorDesdeArchivo.nextInt();
            int dniLeido = dniControl;
            int nroRondaControl = lectorDesdeArchivo.nextInt();
            int nroRondaLeido = nroRondaControl;


            while (lectorDesdeArchivo.hasNext()) {

                while (dniLeido == dniControl) {

                    Carton nuevoCarton = new Carton();

                    while (nroRondaLeido == nroRondaControl) {


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

                        Pronostico nuevoPronostico = new Pronostico(equipo1, equipo2, resultado);
                        nuevoCarton.agregarPronostico(nuevoPronostico);

                        if (lectorDesdeArchivo.hasNextInt()) {
                            dniControl = lectorDesdeArchivo.nextInt();
                            nroRondaLeido = lectorDesdeArchivo.nextInt();
                        }
                        else break;


                        pronosticoDeUnaPersona.agregarPronRonda(nroRondaControl, nuevoCarton);  // guarda los pronosticos de una ronda/carton
                    }
                    nroRondaControl = nroRondaLeido;                                         // actualiza el nroRonda de control




                    agregarJugador(dniControl, pronosticoDeUnaPersona);      // guarda los pronosticos de un jugador de todo el torneo
                }
                dniControl = dniLeido;                                  // actualiza el dni de control



            }



        }
    }



}