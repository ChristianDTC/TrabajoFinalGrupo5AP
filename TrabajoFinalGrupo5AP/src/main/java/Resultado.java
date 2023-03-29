public class Resultado(Equipo equipo) {


    if(equipo.getGolesEquipo1 == golesEquipo2){
        return "empate"
    } else if (golesEquipo1 > golesEquipo2){
        return "gano"
    } else {
        return "perdio"
    }


    if( Resultado == "empate"){
        puntos ++
    }else if ( Resultado == "gano"){
        puntos +=2
    }
}