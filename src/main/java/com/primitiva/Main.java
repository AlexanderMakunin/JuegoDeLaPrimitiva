package com.primitiva;

import com.primitiva.Juego.Boleto;
import com.primitiva.Juego.JuegoPrimitiva;

import java.util.Arrays;

//TODO implementar try and catch para valores que no sean numeros, la comprobacion de sin son del 1 al 49 o asi ya esta hecha en Boleto. Alex: Terminado
public class Main {
    // Array de los numeros
    public final static int[] num = new int[PrimitivaConstantes.TOTAL_NUMEROS];
    // String para que el usuario introduzca los datos
    private static int numIntroducido;
    private static String inputNoValido;
    // Clase boleto
    public static Boleto boleto;
    public static void main(String[] args) {
        // Crear boletos
        crearBoleto();
        // El menu
        menu();
    }
    /*
    Este sera el boleto con el que jugara la persona
     */
    private static void crearBoleto(){
        System.out.println(decoradorDeTexto("*** Hagamos sus numeros de la suerte ***",false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        // Pedir al usuario si lo hace a mano o aleatorio
        System.out.println(decoradorDeTexto("*** Quieres introducirlos a mano? (S/N) ***",false,dondeColor(PrimitivaConstantes.COLORES.BLANCO,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        char numerosDeLaSuerte;
        try {
            numerosDeLaSuerte = PrimitivaConstantes.sc.nextLine().charAt(0);
        } catch (StringIndexOutOfBoundsException SOFBE) {
            do {
                System.err.println("Valor introducido no valido, vuelve a intentarlo");
                inputNoValido = PrimitivaConstantes.sc.nextLine();
            } while (inputNoValido.isEmpty());
            numerosDeLaSuerte = inputNoValido.charAt(0);
        }
        if (numerosDeLaSuerte == 's' || numerosDeLaSuerte == 'S') {
            // en caso de manual ir pidiendo varias veces hasta la longitud del total de numeros
            System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_APUESTA_MANUAL,false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA,false,dondeColor(PrimitivaConstantes.COLORES.BLANCO,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            for (int i = 0; i < num.length; i++) {
                try {
                    System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_INTRODUZCA_NUMERO,false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
                    // pa que si pongas un float o double no pete a la primera
                    numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
                    for (int j = 0; j < i; j++) {
                        if (num[j] == numIntroducido) {
                            System.err.println("No se permiten colocar numeros repetidos");
                            System.err.println("Quiere poner otro numero?");
                            System.err.println("(S para poner otro numero, otro valor creara un boleto automatico)");
                            numerosDeLaSuerte = PrimitivaConstantes.sc.nextLine().charAt(0);
                            if (numerosDeLaSuerte == 'S' || numerosDeLaSuerte == 's') {
                                i--;
                            } else {
                                System.err.println("Creando boleto automaticamente...");
                                boleto = new Boleto();
                                break;
                            }
                        }
                    }
                } catch (NumberFormatException ne) {

                    System.err.println("Valor introducido no valido");
                    System.err.println("Quieres crear uno automatico o volver a intentarlo?");
                    System.err.println("(S para volver a intentarlo, otro valor indicara crear un boleto automatico)");
                    try {
                        numerosDeLaSuerte = PrimitivaConstantes.sc.nextLine().charAt(0);
                    } catch (StringIndexOutOfBoundsException SOFBE) {
                        do {
                            System.err.println("Valor introducido no valido, vuelve a intentarlo");
                            inputNoValido = PrimitivaConstantes.sc.nextLine();
                        } while (inputNoValido.isEmpty());
                        numerosDeLaSuerte = inputNoValido.charAt(0);
                    }
                    if (numerosDeLaSuerte == 'S' || numerosDeLaSuerte == 's') {
                        i--;
                    } else {
                        System.err.println("Creando boleto automaticamente...");
                        boleto = new Boleto();
                        break;
                    }
                }
                // meter los numeros en el array en la cual es el boleto
                num[i] = numIntroducido;
                System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA,false,dondeColor(PrimitivaConstantes.COLORES.BLANCO,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            }
            boleto = new Boleto(num);
        } else {
            // por si a la persona le da flojera hacerlo a mano
            System.out.println(decoradorDeTexto(PrimitivaConstantes.MSG_APUESTA_AUTOMATICA,false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            boleto = new Boleto();
        }

        // mostar el boleto
        System.out.println(decoradorDeTexto(PrimitivaConstantes.LINEA_SEPARADORA,false,dondeColor(PrimitivaConstantes.COLORES.BLANCO,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        System.out.println(decoradorDeTexto("*** Estos son tus numeros de la suerte ***",false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        System.out.println(decoradorDeTexto(boleto.toString(),false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        await();
    }
    /*
    El menu para llamar los metodos de los juegos
     */ //TODO mejora el atractivo como si fuera un casino, puedes usar colores. Alex: Ya termine
    private static void menu() {
        do {
            System.out.println(decoradorDeTexto(PrimitivaConstantes.NOMBREJUEGO,false,dondeColor(PrimitivaConstantes.COLORES.VERDE,false) ,dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** Menu ***",false,dondeColor(PrimitivaConstantes.COLORES.AZUL, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** Elige ***",false,dondeColor(PrimitivaConstantes.COLORES.AZUL, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 1. Juego único ***",false,dondeColor(PrimitivaConstantes.COLORES.NEGRO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 2. Jugar hasta obtener premio ***",false,dondeColor(PrimitivaConstantes.COLORES.AMARILLO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 3. Jugar hasta obtener premio (sin reintegro) ***",false,dondeColor(PrimitivaConstantes.COLORES.MORADO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 4. Ciclo de " + PrimitivaConstantes.CANT_SORTEOS + " sorteos ***",false,dondeColor(PrimitivaConstantes.COLORES.AZULCLARO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 5. Jugar hasta obtener premio categoría especial ***",false,dondeColor(PrimitivaConstantes.COLORES.BLANCO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            System.out.println(decoradorDeTexto("*** 0. Salir ***",false,dondeColor(PrimitivaConstantes.COLORES.ROJO, false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
            try {
                numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                do {
                    System.err.println("Valor introducido no valido, vuelve a intentarlo");
                    inputNoValido = PrimitivaConstantes.sc.nextLine();
                    if (!inputNoValido.isEmpty() && inputNoValido.charAt(0) > 5) {
                        numIntroducido = Integer.parseInt(inputNoValido);
                    }
                } while (inputNoValido.isEmpty());
            }
            switch (numIntroducido) {
                case 0 -> {
                }
                case 1 -> System.out.println(juegos.juegoUnico(boleto));
                case 2 -> System.out.println(juegos.juegoHastaPremio(boleto) + " Sorteos");
                case 3 -> System.out.println(juegos.juegoHastaPremioSinReintegro(boleto) + " Sorteos");
                case 4 -> System.out.println(Arrays.toString(juegos.juegoDeMuchosSorteos(boleto)) + "\n[E, 1º, 2º, 3º, 4º, 5º, R]");
                case 5 -> System.out.println(juegos.juegoHastaEspecialResultado(boleto) + " Sorteos");
                default -> System.err.println("Elija una de las opciones dentro del menu");
            }
            await();
        } while (numIntroducido != 0);
        System.out.println(PrimitivaConstantes.DESPEDIDA);
    }
    private static final JuegoPrimitiva juegos = new JuegoPrimitiva();

    public static String decoradorDeTexto(String texto, boolean negrita, int colorText, int background) {
        int n = negrita ? 1 : 0;
        return "\u001B[" + n +";" + colorText + ";" + background + "m" + texto + "\u001B[0m";
    }

    public static int dondeColor(PrimitivaConstantes.COLORES color, boolean fondo) {
        if (fondo) {
            return PrimitivaConstantes.colores(color, PrimitivaConstantes.TIPOCOLOR.FONDO);
        } else {
            return PrimitivaConstantes.colores(color, PrimitivaConstantes.TIPOCOLOR.TEXTO);
        }
    }

    public static void await() {
        System.out.println(PrimitivaConstantes.LINEA_SEPARADORA);
        System.out.println(decoradorDeTexto("*** Pulse un boton para continuar ***", false,dondeColor(PrimitivaConstantes.COLORES.BLANCO,false),dondeColor(PrimitivaConstantes.COLORES.NULL,true)));
        PrimitivaConstantes.sc.nextLine();
    }
}