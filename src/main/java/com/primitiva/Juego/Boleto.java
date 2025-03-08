package com.primitiva.Juego;

import com.primitiva.PrimitivaConstantes;
import java.util.Arrays;

public class Boleto {
    private final int[] numerosPrincipales;
    private final int reintegro;

    public Boleto(int[] numerosPrincipales) {
        if (!esValido(numerosPrincipales)) {
            this.numerosPrincipales = generarBoletoAleatorio(PrimitivaConstantes.NUMERO_MAX, PrimitivaConstantes.TOTAL_NUMEROS);
        } else {
            this.numerosPrincipales = numerosPrincipales;
        }
        this.reintegro = PrimitivaConstantes.rnd.nextInt(PrimitivaConstantes.REINTEGRO_MAX + 1);
    }


    //para boleto aleatorio
    public Boleto() {
        this.numerosPrincipales = generarBoletoAleatorio(PrimitivaConstantes.NUMERO_MAX, PrimitivaConstantes.TOTAL_NUMEROS);
        this.reintegro = PrimitivaConstantes.rnd.nextInt(PrimitivaConstantes.REINTEGRO_MAX + 1);
    }

    /**
     * Genera un boleto aleatorio del rango y longitud que quieras
     *
     * @param n numeros disponibles para el boleto
     * @param b cantidad de numeros del boleto
     * @return devuelve un array de enteros con tu boleto generado
     */
    private int[] generarBoletoAleatorio(int n, int b) {
        int[] nums = new int[n];
        int[] bol = new int[b];
        int size = nums.length;
        int index;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < b; i++) {
            index = PrimitivaConstantes.rnd.nextInt(size);
            bol[i] = nums[index];
            nums[index] = nums[--size];
        }
        return bol;
    }

    /**
     *
     * @param numerosPrincipales boleto a comprobar
     * @return devuelve si el boleto es valido, 6 nums, no repetidos,etc
     */
    private boolean esValido(int[] numerosPrincipales) {
        if (numerosPrincipales == null || numerosPrincipales.length != PrimitivaConstantes.TOTAL_NUMEROS) return false;

        for (int i = 0; i < numerosPrincipales.length; i++) {
            for (int j = i + 1; j < numerosPrincipales.length; j++) {
                if (numerosPrincipales[i] == numerosPrincipales[j]) return false;
            }
        }
        return true;
    }

    public int[] getNumerosPrincipales() {
        return Arrays.copyOf(numerosPrincipales, numerosPrincipales.length);
    }

    public int getReintegro() {
        return reintegro;
    }

    @Override
    public String toString() {
        return "Boleto [numeros="
                + Arrays.toString(numerosPrincipales)
                + ", reintegro="
                + reintegro
                + "]";
    }
}
