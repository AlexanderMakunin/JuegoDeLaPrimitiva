package com.primitiva;

import java.util.Arrays;

public class Bombo {
    private final int[] numerosPrincipales;
    private final int complementario;
    private final int reintegro;

    public Bombo() {
        this.numerosPrincipales = generarNumerosGanadores();
        this.complementario = 5; // numero temporal
        this.reintegro = PrimitivaConstantes.rnd.nextInt(10) ;
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
        int[] arrayPool = generarPool();

        int[] arrayAleatorio = new int[PrimitivaConstantes.TOTAL_NUMEROS];
        boolean[] usados = new boolean[arrayPool.length];

        int contador = 0;
        while (contador < 6) {
            int indice = PrimitivaConstantes.rnd.nextInt(arrayPool.length);

            if (!usados[indice]) {
                arrayAleatorio[contador] = arrayPool[indice];
                usados[indice] = true;
                contador++;
            }
        }
        return arrayAleatorio;
    }

    private int[] generarPool(){
        int[] array = new int[PrimitivaConstantes.COMPLEMENTARIO_MAX - PrimitivaConstantes.COMPLEMENTARIO_MIN];

        for(int i = PrimitivaConstantes.COMPLEMENTARIO_MIN; i <= PrimitivaConstantes.COMPLEMENTARIO_MAX; i++){
            array[i] = i;
        }

        return array;
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
