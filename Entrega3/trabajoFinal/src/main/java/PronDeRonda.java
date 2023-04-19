import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
@Getter@Setter
public class PronDeRonda {
    private ArrayList<Pronostico> pronosticos;
    private int puntaje = 0;

    private int pronosticosAcertados = 0;

    public PronDeRonda() {
        pronosticos = new ArrayList<>();
    }

    public ArrayList<Pronostico> getPronosticos() {
        return pronosticos;
    }

    public Resultado consultarResultado(int i) {
        return pronosticos.get(i).getResultado();
    }

    public int cantidadPronosticos() {
        return pronosticos.size();
    }

    // El archivo csv debe estar guardado en la carpeta "resources"
    public void cargarPronostico(String nombre) throws IOException, SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados","root","lapaloma");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from pronosticos where participante = "+ nombre);
        if (conn != null) {
            while (rs.next()) {

                String equipo1 = rs.getString("equipo1");
                String equipo2 = rs.getString("equipo2");
                String participante = rs.getString("participante");
                Resultado resultado = null;
                if (rs.getString("gana1").contains("x")) {
                    resultado = Resultado.GANO1;
                }

                if (rs.getString("empata").contains("x")) {
                    resultado = Resultado.EMPATE;
                }

                if (rs.getString("gana2").contains("x")) {
                    resultado = Resultado.GANO2;
                }

                Pronostico nuevo = new Pronostico(equipo1, equipo2, resultado, participante);
                this.pronosticos.add(nuevo);
            }

            rs.close();
            conn.close();
        }else System.out.println("Error: no se pudo conectar");
    }



}
