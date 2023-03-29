public class Ronda {

    private String numeroDeRonda;
    private private ArrayList<Partido> partidos;

    public Ronda(String numeroDeRonda, ArrayList<Partido> partidos) {
        this.numeroDeRonda = numeroDeRonda;
        this.partidos = partidos;
    }

    public String getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setNumeroDeRonda(String numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
}