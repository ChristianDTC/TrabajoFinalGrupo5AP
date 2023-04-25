import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
@Getter
public class Participantes {

    private ArrayList<Persona> personas;

    public Participantes() {
        personas = new ArrayList<>();
    }

    public void cargarPersonas() throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/resultados", "root", "lapaloma");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from Persona");
        if (conn != null) {
            while (rs.next()) {

                String nom = rs.getString("Nombre");
                String ape = rs.getString("Apellido");
                String dni = rs.getString("DNI");
                Persona p = new Persona(nom, ape, dni);
                this.personas.add(p);
            }

            rs.close();
            conn.close();
        } else System.out.println("Error: no se pudo conectar");
    }

    public void cargarPuntaje(Torneo torneo, Boleta boleta) {

        for (int i = 0; i < personas.size(); i++) {
            int puntaje = 0;

            for (int j = 0; j < torneo.getTodosLosPartidos().size(); j++) {

                if (torneo.getTodosLosPartidos().get(j).getResultado() == boleta.getBoleta().get(personas.get(i).getDni()).consultarResultado(j))
                    puntaje++;
            }
            personas.get(i).setPuntaje(puntaje);
        }


    }
}
