import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.*;
import java.util.HashMap;
@Getter
@Setter
@AllArgsConstructor

public class Juego {

    public HashMap<Persona , TotalPronosticos> juego;

    public Juego(){juego = new HashMap<>();}

    public int cantidadPronosticos(){
        int cant = 0;

        for (TotalPronosticos pronosticosDeUnaPersona : juego.values()) {
            cant += pronosticosDeUnaPersona.cantidadPronosticos();
        }
        return cant;
    }

    public void cargarPronosticosDB(Configuracion cfg, Jugadores jugadores) throws SQLException {

        String url = cfg.getUrlDB();                                        //carga datos desde json
        String user = cfg.getUserDB();                                      //carga datos desde json
        String pass = cfg.getRootPasswordDB();                              //carga datos desde json

        Connection cn = DriverManager.getConnection(url,user,pass);

        Statement st = cn.createStatement();

        // Averigua la cantidad de fases y rondas consultando cuál es el nro mayor
        ResultSet rs1 = st.executeQuery("SELECT max(nroFase) as cantFase, max(nroRonda) as cantRonda FROM pronostico");

        rs1.next();
        int cantFase = rs1.getInt("cantFase");
        int cantRonda = rs1.getInt("cantRonda");

        // Lee las filas de la DB e instancia los pronósticos: Pronostico --> Boleta --> PronosticosFase --> TotalPronosticos --> Juego (asociado con una Persona)
        for (Persona persona : jugadores.getJugadores()) {
            TotalPronosticos totalPronosticosDeUnaPersona = new TotalPronosticos();

            for (int i = 1; i <= cantFase ; i++) {
                PronosticosFase nuevoPronosticoFase = new PronosticosFase();
                for (int j = 1; j <= cantRonda; j++) {
                    Boleta nuevaBoleta = new Boleta();

                    String sql = "select * from pronostico where nroFase = " + i + " and nroRonda = " + j + " and dni = " + persona.getDni();
                    rs1 = st.executeQuery(sql);

                    while (rs1.next()){

                        int dni = rs1.getInt("dni");
                        int nroFase = rs1.getInt("nroFase");
                        int nroRonda = rs1.getInt("nroRonda");
                        String equipo1 = rs1.getString("equipo1");
                        String equipo2 = rs1.getString("equipo2");
                        Resultado resultado = Resultado.NA;
                        if (rs1.getBoolean("Gana1")) resultado = Resultado.GANO1;
                        if (rs1.getBoolean("Gana2")) resultado = Resultado.GANO2;
                        if (rs1.getBoolean("empate")) resultado = Resultado.EMPATE;
                        Pronostico nuevo = new Pronostico(dni,nroFase,nroRonda,equipo1,equipo2,resultado);
                        nuevaBoleta.agregarPronostico(nuevo);
                    }
                    nuevoPronosticoFase.agregarPronostico(nuevaBoleta);
                }
                totalPronosticosDeUnaPersona.agregarPronostico(nuevoPronosticoFase);
            }
            juego.put(persona, totalPronosticosDeUnaPersona);
        }
        rs1.close();
        cn.close();
    }

    public void calcularPuntaje(Jugadores jugadores , Torneo torneo, Configuracion cfg) {

        // calcula si cada pronóstico instanciado acertó su predicción y guarda esa información en cada pronóstico.
        for (Persona jugador : jugadores.getJugadores()) {
            for (PronosticosFase pronosticosFase : juego.get(jugador).iterar()) {
                for (Boleta boleta : pronosticosFase.iterar()) {
                    for (Pronostico pronostico : boleta.iterar()) {
                        pronostico.acierto(torneo, jugador);
                    }
                }
            }
        }

        // calcula el puntaje de cada persona y guarda el cálculo en cada persona
        int cantBonusRonda = 0;
        int cantBonusFase = 0;

        for (Persona jugador : jugadores.getJugadores()) {
            for (PronosticosFase pronosticosFase : juego.get(jugador).iterar()) {
                if (pronosticosFase.bonus()) {
                    cantBonusFase++;
                }
                for (Boleta boleta : pronosticosFase.iterar()) {
                    if (boleta.bonus()) {
                        cantBonusRonda++;
                    }
                }
            }
            int ptsAcierto = jugador.getAciertos() * cfg.getPtsAcierto();
            int bonusRonda = cantBonusRonda * cfg.getPtsRonda();
            int bonusFase = cantBonusFase * cfg.getPtsFase();

            int puntaje = ptsAcierto + bonusRonda + bonusFase;
            jugador.setPuntaje(puntaje);
        }


    }
}