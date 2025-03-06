package com.primitiva;

import java.time.LocalDateTime;
import java.util.Arrays;

// Clase inmutable que representa un resultado de sorteo
public class ResultadoSorteo {
  private int[] combinacion;
  private int complementario;
  private int reintegro;
  private LocalDateTime fechaHora;

  public ResultadoSorteo(int[] combinacion, int complementario, int reintegro) {
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

  // Setters para la mutación del objeto
  public void setCombinacion(int[] combinacion) {
    this.combinacion = Arrays.copyOf(combinacion, combinacion.length);
  }

  public void setComplementario(int complementario) {
    this.complementario = complementario;
  }

  public void setReintegro(int reintegro) {
    this.reintegro = reintegro;
  }

  public void setFechaHora(LocalDateTime fechaHora) {
    this.fechaHora = fechaHora;
  }
}
