package com.primitiva;

import java.util.Arrays;

public class Bombo {
    private int[] pool;
    private int size;

    public Bombo(int min, int max) {
        this.pool = generarPool(min, max);
        this.size = pool.length;

    }


    public void reiniciarBolas() {
        size = pool.length;
    }


    private void sacarNumerosEnArray(int [] array){
        for(int i = 0; i < array.length; i++){
            int indice = PrimitivaConstantes.rnd.nextInt(0,size);

            array[i] = pool[indice];
            moveToLeft(indice);

        }
    }


    private int sacarUnNumero(){
        return pool[PrimitivaConstantes.rnd.nextInt(0,size)];
    }



    private int[] generarPool(int min, int max){
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
        return "contenido Bombo [numeros="
                + Arrays.toString(pool)
                + "]";
    }
}
