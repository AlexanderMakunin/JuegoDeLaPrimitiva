package com.primitiva;

import java.util.Arrays;

public class Sorteo {
    private final int[] combinacionGanadora;
    private final int complementario;
    private final int reintegro;

    private final Bombo bomboPrincipal;
    private final Bombo bomboReintegro;

    public Sorteo(Bombo bomboPrincipal, Bombo bomboReintegro) {
        this.bomboPrincipal = bomboPrincipal;
        this.bomboReintegro = bomboReintegro;


        this.combinacionGanadora = generarCombinacionGanadora();
        this.complementario =  generarComplementario();
        this.reintegro = generarReintegro();


    }

    private int[] generarCombinacionGanadora() {
        //TODO: Implementar la lógica para sacar 6 numeros del bomboPrincipal

        int[] numeros = bomboPrincipal.sacarNumeros(6);
        return numeros;
    }

    private int generarComplementario() {
        //TODO: Implementar la lógica para sacar  numeros del bomboPrincipal
        return bomboPrincipal.sacarUnNumero();
    }

    private int generarReintegro() {
        //TODO: Implementar la lógica para sacar  numeros del bomboPrincipal
        return bomboReintegro.sacarUnNumero();
    }

    // Muy importante copia para que no se modifique y de aqui Mireya hace los juegos
    public int[] getCombinacionGanadora() {
        return Arrays.copyOf(combinacionGanadora, combinacionGanadora.length);
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }
}