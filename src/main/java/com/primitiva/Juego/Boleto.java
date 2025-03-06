package com.primitiva.Juego;

import com.primitiva.PrimitivaConstantes;

import java.util.Arrays;

public class Boleto {
    private final int[] numerosPrincipales;
    private final int reintegro;

    public Boleto(int[] numerosPrincipales) {
        if (numerosPrincipales.length != 6) {
            throw new IllegalArgumentException("El boleto debe tener exactamente 6 números.");
        }
        this.numerosPrincipales = numerosPrincipales;
        this.reintegro = PrimitivaConstantes.rnd.nextInt(10);
    }

    //falta por implementar
    public Boleto() {
        this.numeros = generarNumerosAleatorios();
        this.reintegro = PrimitivaConstantes.rnd.nextInt(10);
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
