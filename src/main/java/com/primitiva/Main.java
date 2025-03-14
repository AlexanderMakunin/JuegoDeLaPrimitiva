package com.primitiva;

import com.primitiva.Juego.Boleto;
import com.primitiva.Juego.JuegoPrimitiva;

import java.util.Arrays;

public class Main {
    // Array de los numeros
    public static int[] num = new int[PrimitivaConstantes.TOTAL_NUMEROS];
    // String para que el usuario introduzca los datos
    private static int numIntroducido;
    private static String input;
    private static char respuesta;
    // Clase boleto
    public static Boleto boleto;

    public static void main(String[] args) {
        // Crear boletos
        crearBoleto();
        // El menu
        menu();
    }

    /**
     * crear el objeto Boleto
     */
    private static void crearBoleto() {
        respuesta = preguntarFormaDeCrearBoleto();
        if (respuesta == 's' || respuesta == 'S') {
            // en caso de manual ir pidiendo varias veces hasta la longitud del total de numeros
            System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_APUESTA_MANUAL, false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA, false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            num = crearBoletoManual();
            boleto = new Boleto(num);
        } else {
            // por si a la persona le da flojera hacerlo a mano
            System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_APUESTA_AUTOMATICA, false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            boleto = new Boleto();
        }

        // mostar el boleto
        System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA, false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        System.out.println(decoradorDeTexto("*** Estos son tus numeros de la suerte ***", false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        System.out.println(decoradorDeTexto(boleto.toString(), false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        await();
    }

    /**
     * Como crear el boleto auto o manual
     * @return la respuesta de auto o manual
     */
    private static char preguntarFormaDeCrearBoleto() {
        System.out.println(decoradorDeTexto("*** Hagamos sus numeros de la suerte ***", false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        // Pedir al usuario si lo hace a mano o aleatorio
        System.out.println(decoradorDeTexto("*** Quieres introducirlos a mano? (S/N) ***", false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        return validarRespuestaChar();
    }

    /**
     * Para validar si lo que se introduce es un char
     * @return un numero
     */
    private static char validarRespuestaChar() {
        do {
            try {
                input = PrimitivaConstantes.sc.nextLine();
            } catch (StringIndexOutOfBoundsException SOFBE) {
                System.err.println("Valor introducido no valido, vuelve a intentarlo");
            }

        } while (input.isEmpty());
        return respuesta = input.charAt(0);
    }

    /**
     * Para validar si lo que se introduce es un numero
     * @return un numero
     */
    private static int validarNum() {
        do {
            try {
                numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                System.err.println("Valor introducido no valido, vuelve a intentarlo");
                numIntroducido = Integer.MIN_VALUE;
            }
        } while (numIntroducido == Integer.MIN_VALUE);
        return numIntroducido;
    }

    /**
     * Para crear el boleto manualmente
     * @return un array de ints para crear el boleto
     */
    private static int[] crearBoletoManual() {
        for (int i = 0; i < num.length; i++) {
            System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_INTRODUZCA_NUMERO, false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            // pa que si pongas un float o double no pete a la primera
            numIntroducido = validarNum();
            for (int j = 0; j < i; j++) {
                if (num[j] == numIntroducido) {
                    System.err.println("No se permiten colocar numeros repetidos");
                    System.err.println("Quiere poner otro numero?");
                    System.err.println("(S para poner otro numero, otro valor creara un boleto automatico)");
                    respuesta = PrimitivaConstantes.sc.nextLine().charAt(0);
                    if (respuesta == 'S' || respuesta == 's') {
                        i--;
                    } else {
                        System.err.println("Creando boleto automaticamente...");
                        boleto = new Boleto();
                        break;
                    }
                }
            }
            num[i] = numIntroducido;
        }
        // meter los numeros en el array en la cual es el boleto
        System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA, false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        return num;
    }

    /**
     * El menu del programa
     */
    private static void menu() {
        do {
            System.out.println(decoradorDeTexto(PrimitivaConstantes.NOMBREJUEGO, false, dondeColor(PrimitivaConstantes.COLORES.VERDE, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** Menu ***", false, dondeColor(PrimitivaConstantes.COLORES.AZUL, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** Elige ***", false, dondeColor(PrimitivaConstantes.COLORES.AZUL, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 1. Juego único ***", false, dondeColor(PrimitivaConstantes.COLORES.NEGRO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 2. Jugar hasta obtener premio ***", false, dondeColor(PrimitivaConstantes.COLORES.AMARILLO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 3. Jugar hasta obtener premio (sin reintegro) ***", false, dondeColor(PrimitivaConstantes.COLORES.MORADO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 4. Ciclo de " + PrimitivaConstantes.CANT_SORTEOS + " sorteos ***", false, dondeColor(PrimitivaConstantes.COLORES.AZULCLARO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 5. Jugar hasta obtener premio categoría especial ***", false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            System.out.println(decoradorDeTexto("*** 0. Salir ***", false, dondeColor(PrimitivaConstantes.COLORES.ROJO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
            numIntroducido = validarNum();
            for (int i = 3; i > 0; i--) {
                try {
                    System.out.println("La respuesta llega en: " + i);
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException ignored) {
                }
            }
            switch (numIntroducido) {
                case 0 -> {
                }
                case 1 -> System.out.println(juegos.juegoUnico(boleto) + ", " + juegos.obtenerUltimoSorteo());
                case 2 -> System.out.println(juegos.juegoHastaPremio(boleto) + " Sorteos");
                case 3 -> System.out.println(juegos.juegoHastaPremioSinReintegro(boleto) + " Sorteos");
                case 4 ->
                        System.out.println(Arrays.toString(juegos.juegoDeMuchosSorteos(boleto)) + "\n[E, 1º, 2º, 3º, 4º, 5º, R]");
                case 5 ->
                        System.out.println(juegos.juegoHastaEspecialResultado(boleto) + " Sorteos" + juegos.obtenerUltimoSorteo());
                default -> System.err.println("Elija una de las opciones dentro del menu");
            }
            await();
        } while (numIntroducido != 0);
        System.out.println(PrimitivaConstantes.DESPEDIDA);
    }

    /**
     * Crear los juegos
     */
    private static final JuegoPrimitiva juegos = new JuegoPrimitiva();

    /**
     * Su funcion es recibir el texto y decorarlo con colores
     * @param texto el texto a recibir
     * @param negrita si el texto se quiere en negrita
     * @param colorText el color del texto
     * @param background el fondo del texto
     * @return el texto decorado
     */
    public static String decoradorDeTexto(String texto, boolean negrita, int colorText, int background) {
        int n = negrita ? 1 : 0;
        return "\u001B[" + n + ";" + colorText + ";" + background + "m" + texto + "\u001B[0m";
    }

    /**
     * Esto es para hacerlo mas simple en la cual pide un color y si es para el fondo o no
     * @param color el color que se quiere
     * @param fondo si para el fondo o no
     * @return devuelve el numero del color dependiendo si es para el fondo o no
     */
    public static int dondeColor(PrimitivaConstantes.COLORES color, boolean fondo) {
        if (fondo) {
            return PrimitivaConstantes.colores(color, PrimitivaConstantes.TIPOCOLOR.FONDO);
        } else {
            return PrimitivaConstantes.colores(color, PrimitivaConstantes.TIPOCOLOR.TEXTO);
        }
    }

    /**
     * Es para hacer que el programa espere y asi el usuario tenga que pulsar un boton para continuar
     */
    public static void await() {
        System.out.println(PrimitivaConstantes.LINEA_SEPARADORA);
        System.out.println(decoradorDeTexto("*** Pulse un boton para continuar ***", false, dondeColor(PrimitivaConstantes.COLORES.BLANCO, false), dondeColor(PrimitivaConstantes.COLORES.NULL, true)));
        PrimitivaConstantes.sc.nextLine();
    }
}