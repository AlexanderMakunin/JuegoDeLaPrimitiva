package com.primitiva;

import java.util.Arrays;

public class Sorteo {
    private final Bombo bomboPrincipal;
    private final Bombo bomboReintegro;

    public Sorteo(Bombo bomboPrincipal, Bombo bomboReintegro) {
        this.bomboPrincipal = bomboPrincipal;
        this.bomboReintegro = bomboReintegro;
    }

    // Muy importante copia para que no se modifique y de aqui Mireya hace los juegos
    public int[] getCombinacionGanadora() {      // 6 NO REPETIBLES
        int[] numeros = bomboPrincipal.sacarNumeros(6);
        return  Arrays.copyOf(numeros,numeros.length) ;
    }

    private int generarComplementario() {
        //TODO: Implementar la lógica para sacar  numeros del bomboPrincipal, DE LOS 43 RESTANTES no puede ser igual a los 6
        return bomboPrincipal.sacarUnNumero();
    }

    private int generarReintegro() {
        //TODO: Implementar la lógica para sacar  numeros del bomboPrincipal , DEL SEGUNDO BOMBO puede ser repe porque es de otro bombo
        return bomboReintegro.sacarUnNumero();
    }



    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }
}