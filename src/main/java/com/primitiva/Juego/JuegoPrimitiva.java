package com.primitiva.Juego;

import com.primitiva.GestionSorteo.ResultadoSorteo;
import com.primitiva.GestionSorteo.Sorteo;
import com.primitiva.PrimitivaConstantes;

public class JuegoPrimitiva {

    public enum Premios{
        ESPECIAL("Premio especial"),
        PRIMERO("Primer premio"),
        SEGUNDO("Segundo premio"),
        TERCERO("Tercer premio"),
        CUARTO("Cuarto premio"),
        QUINTO("Quinto premio"),
        NINGUNO("No has ganado nada");

        private final String texto;


        Premios(String texto){
            this.texto = texto;
        }

        @Override
        public String toString(){
            return texto;
        }
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
        iteraciones = 0;
        do { //TODO implementar sin statics
            aciertos = 0;
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
        }while (aciertos < 3 || reintegro);
        return iteraciones;
    }

    // Jugar hasta obtener el premio sin reintegro
    public static long juegoHastaPremioSinReintegro(Boleto boleto) {
        iteraciones = 0;
        do {
            aciertos = 0;
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
    public static int[] juegoDeMuchosSorteos(Boleto boleto) {
        final int MUCHOS_SORTEOS = 10000;
        final int[] premios = new int[7];

        for (int i = 0; i < MUCHOS_SORTEOS; i++) {
            switch (juegoUnico(boleto)){
                case ESPECIAL -> premios[0]++;
                case PRIMERO -> premios[1]++;
                case SEGUNDO -> premios[2]++;
                case TERCERO -> premios[3]++;
                case CUARTO -> premios[4]++;
                case QUINTO -> premios[5]++;
                default -> {
                    if (boleto.getReintegro() == sorteo.getReintegro()){
                        premios[6]++;
                    }
                }
            }
        }
        return premios;
    }

    // Jugar hasta que salga el especial
    public static long juegoHastaEspecialResultado(Boleto boleto) {
        iteraciones = 0;
        do{
            iteraciones ++;
        }while(juegoUnico(boleto) != Premios.ESPECIAL);
        return ;
    }

    public long getIteraciones(){
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
