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

  public Boleto(int[] numerosPrincipales) {
    this.numerosPrincipales = numerosPrincipales;
    this.reintegro = PrimitivaConstantes.rnd.nextInt(10) ;
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
