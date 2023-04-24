import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class Configuracion {

    private String urlDB;
    private String userDB;
    private String rootPasswordDB;
    private int ptsAcierto;
    private int ptsRonda;
    private int ptsFase;

}