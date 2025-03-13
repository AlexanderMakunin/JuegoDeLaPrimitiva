package com.primitiva.Juego;

import com.primitiva.GestionSorteo.Bombo;
import com.primitiva.GestionSorteo.ResultadoSorteo;
import com.primitiva.GestionSorteo.Sorteo;
import com.primitiva.PrimitivaConstantes;

public class JuegoPrimitiva {

    private final Sorteo sorteo;

    public JuegoPrimitiva(){
        Bombo bomboPrincipal = new Bombo(PrimitivaConstantes.NUMERO_MIN, PrimitivaConstantes.NUMERO_MAX);
        Bombo bomboReintegro = new Bombo(PrimitivaConstantes.REINTEGRO_MIN, PrimitivaConstantes.REINTEGRO_MAX);
        this.sorteo = new Sorteo(bomboPrincipal, bomboReintegro);
    }


    // Juego de una sola vez
    public Premios juegoUnico(Boleto boleto) {
        sorteo.generar();
        int aciertos = calcularAciertos(boleto);
        boolean reintegro = boleto.getReintegro() == sorteo.getReintegro();
        boolean complementario = calcularComplementario(boleto);

        return determinarPremio(aciertos, reintegro, complementario);
    }

    private int calcularAciertos(Boleto boleto) {
        int aciertos = 0;
        for (int numero : boleto.getNumerosPrincipales()) {
            for (int resultado : sorteo.getResultado()) {
                if (numero == resultado) {
                    aciertos++;
                    break;
                }
            }
        }
        return aciertos;
    }

    private boolean calcularComplementario(Boleto boleto) {
        if (calcularAciertos(boleto) == 5) {
            for (int numero : boleto.getNumerosPrincipales()) {
                boolean encontrado = false;
                for (int resultado : sorteo.getResultado()) {
                    if (numero == resultado) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    return numero == sorteo.getComplementario();
                }
            }
        }
        return false;
    }


    private Premios determinarPremio(int aciertos, boolean reintegro, boolean complementario) {
        switch (aciertos) {
            case 3:
                return Premios.QUINTO;
            case 4:
                return Premios.CUARTO;
            case 5:
                return complementario ? Premios.SEGUNDO : Premios.TERCERO;
            case 6:
                return reintegro ? Premios.ESPECIAL : Premios.PRIMERO;
            default:
                return Premios.NINGUNO;
        }
    }


    // Jugar hasta obtener el premio
    public long juegoHastaPremio(Boleto boleto) {
        int iteraciones = 0;
        int aciertos;
        boolean reintegro;
        do { //TODO implementar sin statics
            aciertos = 0;
            iteraciones ++;
            sorteo.generar();
            aciertos = calcularAciertos(boleto);
            reintegro = boleto.getReintegro() == sorteo.getReintegro();
        }while (aciertos < 3 || reintegro);
        return iteraciones;
    }

    // Jugar hasta obtener el premio sin reintegro
    public long juegoHastaPremioSinReintegro(Boleto boleto) {
        int iteraciones = 0;
        int aciertos;
        do {
            aciertos = 0;
            iteraciones ++;
            sorteo.generar();
            aciertos = calcularAciertos(boleto);
        }while (aciertos < 3);
        return iteraciones;
    }

    // Jugar X cantidad de veces
    public int[] juegoDeMuchosSorteos(Boleto boleto) {
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
    public int juegoHastaEspecialResultado(Boleto boleto) {
        int iteraciones = 0;
        do{
            iteraciones ++;
        }while(juegoUnico(boleto) != Premios.ESPECIAL);
        return iteraciones;
    }

    public ResultadoSorteo obtenerUltimoSorteo() {
        return sorteo.getResultadoGanador();
    }


}
