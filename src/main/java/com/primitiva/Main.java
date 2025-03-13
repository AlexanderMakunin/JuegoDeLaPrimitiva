package com.primitiva;

import com.primitiva.Juego.Boleto;
import com.primitiva.Juego.JuegoPrimitiva;

import java.util.Arrays;
//TODO implementar try and catch para valores que no sean numeros, la comprobacion de sin son del 1 al 49 o asi ya esta hecha en Boleto
public class Main {
    // Array de los numeros
    public final static int[] num = new int[PrimitivaConstantes.TOTAL_NUMEROS];
    // String para que el usuario introduzca los datos
    private static int numIntroducido;
    // Clase boleto
    public static Boleto boleto;
    public static void main(String[] args) {
        // Crear boletos
        crearwea();
        // El menu
        menu();
    }
    /*
    Este sera el boleto con el que jugara la persona
     */
    private static void crearwea(){
        System.out.println("*** Hagamos sus numeros de la suerte ***");
        // Pedir al usuario si lo hace a mano o aleatorio
        System.out.println("Quieres introducirlos a mano? (S/N)");
        char numerosDeLaSuerte = PrimitivaConstantes.sc.nextLine().charAt(0);
        if (numerosDeLaSuerte == 's' || numerosDeLaSuerte == 'S') {
            // en caso de manual ir pidiendo varias veces hasta la longitud del total de numeros
            System.out.println(PrimitivaConstantes.MSG_APUESTA_MANUAL);
            System.out.println(PrimitivaConstantes.LINEA_SEPARADORA);
            for (int i = 0; i < num.length; i++) {
                System.out.println(PrimitivaConstantes.MSG_INTRODUZCA_NUMERO);
                // pa que si pongas un float o double no pete
                numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
                // verificar que los numeros no esten repetidos o fuera de rango
                for (int j = 0; j < i; j++) {
                    if (num[j] == numIntroducido || numIntroducido > PrimitivaConstantes.NUMERO_MAX || numIntroducido < PrimitivaConstantes.NUMERO_MIN) {
                        while (numIntroducido > PrimitivaConstantes.NUMERO_MAX || numIntroducido < PrimitivaConstantes.NUMERO_MIN) {
                            System.err.println("El numero introducido no es valido: " + numIntroducido + ", vuelve a intentarlo");
                            numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
                        }
                    }
                }
                // meter los numeros en el array en la cual es el boleto
                num[i] = numIntroducido;
            }
            boleto = new Boleto(num);
        } else {
            // por si a la persona le da flojera hacerlo a mano
            System.out.println(PrimitivaConstantes.MSG_APUESTA_AUTOMATICA);
            System.out.println(PrimitivaConstantes.LINEA_SEPARADORA);
            boleto = new Boleto();
        }

        // mostar el boleto
        System.out.println("*** Estos son tus numeros de la suerte ***");
        System.out.println(boleto);
    }
    /*
    El menu para llamar los metodos de los juegos
     */ //TODO mejora el atractivo como si fuera un casino, puedes usar colores.
    private static void menu() {
        do {
            System.out.println("*** Menu ***");
            System.out.println("*** Elige ***");
            System.out.println("*** 1. Juego único ***");
            System.out.println("*** 2. Jugar hasta obtener premio ***");
            System.out.println("*** 3. Jugar hasta obtener premio (sin reintegro) ***");
            System.out.println("*** 4. Ciclo de "+ PrimitivaConstantes.CANT_SORTEOS + " sorteos ***");
            System.out.println("*** 5. Jugar hasta obtener premio categoría especial ***");
            System.out.println("*** 0. Salir ***");
            numIntroducido = (int) Double.parseDouble(PrimitivaConstantes.sc.nextLine());
            switch (numIntroducido) {
                case 1 -> System.out.println(juegos.juegoUnico(boleto));
                case 2 -> System.out.println(juegos.juegoHastaPremio(boleto) + " Sorteos");
                case 3 -> System.out.println(juegos.juegoHastaPremioSinReintegro(boleto) + " Sorteos");
                case 4 -> System.out.println(Arrays.toString(juegos.juegoDeMuchosSorteos(boleto)) + "\n[E, 1º, 2º, 3º, 4º, 5º, R]");
                case 5 -> System.out.println(juegos.juegoHastaEspecialResultado(boleto) + " Sorteos");
            }
        } while (numIntroducido != 0);
        System.out.println("Adios...");
    }

    private static JuegoPrimitiva juegos = new JuegoPrimitiva();
}