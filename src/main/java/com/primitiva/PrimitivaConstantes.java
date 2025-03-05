package com.primitiva;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class PrimitivaConstantes {
  // Entrada y aleatoriedad
  public static final Scanner sc = new Scanner(System.in);
  public static final Random rnd = new Random();

  // Formateadores
  public static final DecimalFormat formatoMoneda = new DecimalFormat("#,##0.00 €");
  public static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  // Constantes específicas de la Primitiva española
  public static final int NUMERO_MIN = 1;
  public static final int NUMERO_MAX = 49;
  public static final int TOTAL_NUMEROS = 6;

  public static final int REINTEGRO_MIN = 0;
  public static final int REINTEGRO_MAX = 9;

  public static final int COMPLEMENTARIO_MIN = 1;
  public static final int COMPLEMENTARIO_MAX = 49;

  // Mensajes comunes
  public static final String MSG_APUESTA_MANUAL = "Selección manual de números";
  public static final String MSG_APUESTA_AUTOMATICA = "Selección automática de números";
  public static final String MSG_INTRODUZCA_NUMERO =
      "Introduzca un número entre " + NUMERO_MIN + " y " + NUMERO_MAX + ": ";

  // Caracteres para presentación
  public static final String LINEA_SEPARADORA = "----------------------------------------";
}
