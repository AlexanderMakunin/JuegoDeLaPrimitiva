package com.primitiva.Juego;

import com.primitiva.GestionSorteo.ResultadoSorteo;
import com.primitiva.GestionSorteo.Sorteo;
import com.primitiva.PrimitivaConstantes;


// señora que estas leyendo esto te wa a echar una mano pa que hagas algo xdd
// *** RECOMENDACIONES ***
// usa while para los casos en que si o si estas buscando el objetivo || buscar hasta PREMIO
// recuerda que solo necesitas comparar datos
// te recomiendo usar esto: CANT_SORTEOS que es la cantidad de veces del muchos sorteos
// no es tan dificil por lo menos haz algo (((((

public class JuegoPrimitiva {
    public enum Premios{
        ESPECIAL, PRIMERO, SEGUNDO, TERCERO, CUARTO, QUINTO, NINGUNO
    }

    private static Sorteo sorteo;
    private static int aciertos;
    private static boolean reintegro;
    private static long iteraciones;

    // Juego de una sola vez
    public static Premios juegoUnico(Boleto boleto) {
        aciertos = 0;
        sorteo.generar();
        reintegro = boleto.getReintegro() == sorteo.getReintegro();
        boolean complement = false;
        int complementario = 0;

        for (int i = 0; i < sorteo.getResultado().length; i++) {
            for (int j = 0; j < sorteo.getResultado().length; j++) {
                if (boleto.getNumerosPrincipales()[i] == sorteo.getResultado()[j]){
                    aciertos ++;
                }
            }
        }

        int aux;

        if (aciertos == 5){
            for (int i = 0; i < sorteo.getResultado().length; i++) {
                aux = 0;
                for (int j = 0; j < sorteo.getResultado().length; j++) {
                    if (boleto.getNumerosPrincipales()[i] == sorteo.getResultado()[j]){
                        aux++;
                    }

                }
                if (aux == 0){
                    complementario = boleto.getNumerosPrincipales()[i];
                }
            }
            complement = complementario == sorteo.getComplementario();
        }


        switch (aciertos){
            case 3 -> {
                return Premios.QUINTO;
            }
            case 4 -> {
                return Premios.CUARTO;
            }
            case 5 -> {
                if (complement){
                    return Premios.SEGUNDO;
                }else {
                    return Premios.TERCERO;
                }
            }
            case 6 -> {
                if (reintegro){
                    return Premios.ESPECIAL;
                }else {
                    return Premios.PRIMERO;
                }
            }
            default -> {
                return Premios.NINGUNO;
            }
        }
    }

    // Jugar hasta obtener el premio
    public static long juegoHastaPremio(Boleto boleto) {
        aciertos = 0;
        iteraciones = 0;
        do {
            iteraciones ++;
            sorteo.generar();
            for (int i = 0; i < sorteo.getResultado().length; i++) {
                for (int j = 0; j < sorteo.getResultado().length; j++) {
                    if (boleto.getNumerosPrincipales()[i] == sorteo.getResultado()[j]){
                        aciertos ++;
                    }
                }
            }
            reintegro = boleto.getReintegro() == sorteo.getReintegro();
        }while (aciertos < 3 || !reintegro);
        return iteraciones;
    }

    // Jugar hasta obtener el premio sin reintegro
    public static long juegoHastaPremioSinReintegro(Boleto boleto) {
        aciertos = 0;
        iteraciones = 0;
        do {
            iteraciones ++;
            sorteo.generar();
            for (int i = 0; i < sorteo.getResultado().length; i++) {
                for (int j = 0; j < sorteo.getResultado().length; j++) {
                    if (boleto.getNumerosPrincipales()[i] == sorteo.getResultado()[j]){
                        aciertos ++;
                    }
                }
            }
        }while (aciertos < 3);
        return iteraciones;
    }

    // Jugar X cantidad de veces
    public static void juegoDeMuchosSorteos(Boleto boleto) {
        final int MUCHOS_SORTEOS = 10000;

        int premioEspecial = 0;
        int premioPrimero = 0;
        int premioSegundo = 0;
        int premioTercero = 0;
        int premioCuarto = 0;
        int premioQuinto = 0;

        for (int i = 0; i < MUCHOS_SORTEOS; i++) {
            switch (juegoUnico(boleto)){
                case ESPECIAL -> premioEspecial++;
                case PRIMERO -> premioPrimero++;
                case SEGUNDO -> premioSegundo++;
                case TERCERO -> premioTercero++;
                case CUARTO -> premioCuarto++;
                case QUINTO -> premioQuinto++;
                default -> ;
            }
        }


    }

    // Jugar hasta que salga el especial
    public static long juegoHastaEspecial(Boleto boleto) {
        iteraciones = 0;
        do{
            iteraciones ++;
        }while();
        return iteraciones;
    }

    public ResultadoSorteo obtenerUltimoSorteo() {
        return sorteo.getResultadoGanador();
    }

    public int obtenerNumeroAciertos() {
        return aciertos;
    }

    public boolean tieneReintegro(){
        return reintegro;
    }

}
