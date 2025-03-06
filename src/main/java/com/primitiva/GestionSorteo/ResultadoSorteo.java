package com.primitiva.GestionSorteo;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Representa el resultado de un sorteo. Esta clase almacena la combinación ganadora,
 * el número complementario, el reintegro y la fecha y hora en que se realizó el sorteo.
 */
public class ResultadoSorteo {
    private int[] combinacion;
    private int complementario;
    private int reintegro;
    private LocalDateTime fechaHora;

    /**
     * Constructor de la clase {@code ResultadoSorteo}.
     *
     * @param combinacion    Array de enteros que representa la combinación ganadora. Se realiza una copia
     *                       defensiva para evitar modificaciones externas.
     * @param complementario El número complementario del sorteo.
     * @param reintegro      El número de reintegro del sorteo.
     */
    public ResultadoSorteo(int[] combinacion, int complementario, int reintegro) {
        if (combinacion == null || combinacion.length != 6) {
            throw new IllegalArgumentException("La combinación debe tener exactamente 6 números.");
        }
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
        this.complementario = complementario;
        this.reintegro = reintegro;
        this.fechaHora = LocalDateTime.now();
    }

    /**
     * Obtiene la combinación ganadora del sorteo.
     *
     * @return Un array de enteros que representa la combinación ganadora. Se retorna una copia
     * defensiva para evitar modificaciones externas.
     */
    public int[] getCombinacion() {
        return Arrays.copyOf(combinacion, combinacion.length);
    }

    /**
     * Obtiene el número complementario del sorteo.
     *
     * @return El número complementario.
     */
    public int getComplementario() {
        return complementario;
    }

    /**
     * Obtiene el número de reintegro del sorteo.
     *
     * @return El número de reintegro.
     */
    public int getReintegro() {
        return reintegro;
    }

    /**
     * Obtiene la fecha y hora del sorteo.
     *
     * @return La fecha y hora en que se realizó el sorteo.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    // Métodos setters package-private para que solo Sorteo los use
    void setCombinacion(int[] combinacion) {
        if (combinacion == null || combinacion.length != 6) {
            throw new IllegalArgumentException("La combinación debe tener exactamente 6 números.");
        }
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
    }

    void setComplementario(int complementario) {
        this.complementario = complementario;
    }

    void setReintegro(int reintegro) {
        this.reintegro = reintegro;
    }

    void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("La fecha/hora no puede ser nula.");
        }
        this.fechaHora = fechaHora;
    }
}