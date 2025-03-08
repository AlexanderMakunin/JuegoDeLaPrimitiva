package com.primitiva.GestionSorteo;

import com.primitiva.PrimitivaConstantes;

import java.time.LocalDateTime;
import java.util.Arrays;

public class ResultadoSorteo {
    private final int[] combinacion;
    private final int complementario;
    private final int reintegro;
    private final LocalDateTime fechaHora;

    public ResultadoSorteo(int[] combinacion, int complementario, int reintegro) {
        if (combinacion == null || combinacion.length != PrimitivaConstantes.TOTAL_NUMEROS) {
            throw new IllegalArgumentException("La combinación debe tener exactamente 6 números.");
        }
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
        this.complementario = complementario;
        this.reintegro = reintegro;
        this.fechaHora = LocalDateTime.now();
    }

    public int[] getCombinacion() {
        return Arrays.copyOf(combinacion, combinacion.length);
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "ResultadoSorteo [combinacion=" + Arrays.toString(combinacion) +
                ", complementario=" + complementario +
                ", reintegro=" + reintegro + "]";
    }
}