import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

// ArrayList con los pronosticos de una persona.
//Pregunta: El ArrayList no se declara sino hasta que se comprueba que el archivo existe. ¿Está bien o es mejor declarla al comienzo

public class Ronda {
    private ArrayList<Partido> partidos;

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
    public void cargarPartido(int i) throws IOException, SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados","root","lapaloma");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from resultados where ronda = "+ i);
        if (conn != null) {
            while (rs.next()) {

                String e1 = rs.getString("equipo1");
                String e2 = rs.getString("equipo2");
                int g1 = rs.getInt("goles1");
                int g2 = rs.getInt("goles2");
                int ron = rs.getInt("ronda");
                Partido nuevo = new Partido(e1, e2, g1, g2, ron);
                this.partidos.add(nuevo);
            }

            rs.close();
            conn.close();
        }else System.out.println("Error: no se pudo conectar");

    }

}
