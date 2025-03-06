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
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
        this.complementario = complementario;
        this.reintegro = reintegro;
        this.fechaHora = LocalDateTime.now();
    }

    /**
     * Obtiene la combinación ganadora del sorteo.
     *
     * @return Un array de enteros que representa la combinación ganadora. Se retorna una copia
     *         defensiva para evitar modificaciones externas.
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
     * Obtiene la fecha y hora en que se realizó el sorteo.
     *
     * @return La fecha y hora del sorteo.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la combinación ganadora del sorteo.
     *
     * @param combinacion El array de enteros que representa la nueva combinación ganadora.
     *                    Se realiza una copia defensiva para evitar modificaciones externas.
     */
    void setCombinacion(int[] combinacion) {
        this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
    }

    /**
     * Establece el número complementario del sorteo.
     *
     * @param complementario El nuevo número complementario.
     */
    void setComplementario(int complementario) {
        this.complementario = complementario;
    }

    /**
     * Establece el número de reintegro del sorteo.
     *
     * @param reintegro El nuevo número de reintegro.
     */
    void setReintegro(int reintegro) {
        this.reintegro = reintegro;
    }

    /**
     * Establece la fecha y hora en que se realizó el sorteo.
     *
     * @param fechaHora La nueva fecha y hora del sorteo.
     */
    void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}