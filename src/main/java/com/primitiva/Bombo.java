package com.primitiva;

import java.util.Arrays;

public class Bombo {
    private final int[] numerosPrincipales;
    private final int complementario;
    private final int reintegro;
    private int[] pool = generarPool();

    public Bombo() {
        this.numerosPrincipales = generarNumerosGanadores();
        this.complementario = generarComplementario();
        this.reintegro = PrimitivaConstantes.rnd.nextInt(PrimitivaConstantes.REINTEGRO_MIN, PrimitivaConstantes.REINTEGRO_MAX + 1) ;
    }

    public int[] getNumerosPrincipales() {
        return Arrays.copyOf(numerosPrincipales, numerosPrincipales.length);
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }


    private int[] generarNumerosGanadores(){
        int[] arrayAleatorio = new int[PrimitivaConstantes.TOTAL_NUMEROS];


        for(int i = 0; i < PrimitivaConstantes.TOTAL_NUMEROS; i++){
            int indice = PrimitivaConstantes.rnd.nextInt(0,pool.length - i);

            arrayAleatorio[i] = pool[indice];
            moveToLeft(indice);

        }

        return arrayAleatorio;
    }

    private int generarComplementario(){
        return pool[PrimitivaConstantes.rnd.nextInt(0,pool.length - PrimitivaConstantes.TOTAL_NUMEROS)];
    }

    private int[] generarPool(){
        int[] array = new int[(PrimitivaConstantes.NUMERO_MAX + 1) - PrimitivaConstantes.NUMERO_MIN];
        int contador = 0;

        for(int i = PrimitivaConstantes.NUMERO_MIN; i <= PrimitivaConstantes.NUMERO_MAX; i++){
            array[contador] = i;
            contador++;
        }

        return array;
    }

    private void moveToLeft(int indice) {
        int aux = pool[indice];

        for (int i = indice; i < pool.length - 1; i++) {
            pool[i] = pool[i + 1];
        }

        pool[pool.length-1] = aux;
    }


    @Override
    public String toString() {
        return "Resultado Bombo [numeros="
                + Arrays.toString(numerosPrincipales)
                + ", complementario="
                + complementario
                + ", reintegro="
                + reintegro
                + "]";
    }
}
