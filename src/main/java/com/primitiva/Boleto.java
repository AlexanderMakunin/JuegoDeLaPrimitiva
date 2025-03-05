package com.primitiva;

import java.util.Arrays;

/**
 * DTO (Data Transfer Object) para representar un boleto de La Primitiva. Contiene los números
 * principales y el número de reintegro.
 *
 * <p>Podríamos usar un 'record' (a partir de Java 14) para una representación más concisa si la
 * inmutabilidad es un requisito estricto.
 */
public class Boleto {
  private final int[] numerosPrincipales;
  private final int reintegro;

  /**
   * Constructor para crear un objeto Boleto.
   *
   * @param numerosPrincipales Array de 6 enteros que representan los números principales del
   *     boleto.
   * @param reintegro Entero que representa el número de reintegro del boleto.
   */
  public Boleto(int[] numerosPrincipales, int reintegro) {
    this.numerosPrincipales = numerosPrincipales;
    this.reintegro = reintegro;
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
