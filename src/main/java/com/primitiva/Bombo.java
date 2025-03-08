package com.primitiva;

import java.util.Arrays;

public class Bombo {
    private final int[] bolas;
    private int[] pool;
    private int size;

    public Bombo(int[] array, int max, int min) {
        this.pool = generarPool(max, min);
        this.size = pool.length;
        generarNumerosGanadores(array);
        this.bolas = array;
    }

    public int[] getBolas() {
        return bolas;
    }

    public void reiniciarBolas() {size = pool.length;}

    private void generarNumerosGanadores(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = generarBola();

        }
    }

    private int generarBola(){
        int bola;
        int indice = PrimitivaConstantes.rnd.nextInt(0, size);

        moveToLeft(indice);
        bola = pool[indice];

        return bola;
    }

    private int[] generarPool(int max, int min){
        int[] array = new int[(max + 1) - min];
        int contador = 0;

        for(int i = min; i <= max; i++){
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
        size--;

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
