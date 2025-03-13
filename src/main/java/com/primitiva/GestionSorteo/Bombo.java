package com.primitiva.GestionSorteo;

import com.primitiva.PrimitivaConstantes;

import java.util.Arrays;
//TODO javadocs
public class Bombo {
    private final int[] pool;
    private int size;

    public Bombo(int min, int max) {
        this.pool = generarPool(min, max);
        this.size = pool.length;

    }


    public void reiniciarBolas() {
        size = pool.length;
    }

    //TODO que sacar un numero haga basicamente esta operacion , y en sacarNumerosenArray x los que sean por parametro, solo llamar al metodo sacarBola/SacarUno
    public void sacarNumerosEnArray(int [] array){
        for(int i = 0; i < array.length; i++){
            int indice = PrimitivaConstantes.rnd.nextInt(0,size);

            array[i] = pool[indice];
            moveToLeft(indice);

        }
    }


    public int sacarUnNumero(){
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
    //TODO quitar este metodo , no es necesario desplazar
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
