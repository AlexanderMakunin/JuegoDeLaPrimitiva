package com.primitiva;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Random
    private static final Random aleatorio = new Random();
    // Array de los numeros
    private final static int[] num = new int[6];
    // numero de re integro
    private static int numReintegro = 0;
    // numero minimo de la suerte
    private static final int numMin = 1;
    // numero maximo de la suerte
    private static final int numMax = 49;
    // numero maximo de re integro
    private static final int numMaxReintegro = 10;
    // String para que el usuario introduzca los datos
    private static int numIntroducido;
    // Scanner para leer los datos
    private static final Scanner leer = new Scanner(System.in);
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
        System.out.println("*** Hagamos sus numeros de la suerte ***");
        System.out.println("Quieres introducirlos a mano? (S/N)");
        char numerosDeLaSuerte = leer.nextLine().charAt(0);
        if (numerosDeLaSuerte == 's' || numerosDeLaSuerte == 'S') {
            for (int i = 0; i < num.length; i++) {
                System.out.println("Indique su numero de la suerte num (entre 1 al 49): " + (i+1));
                numIntroducido = Integer.parseInt(leer.nextLine());
                while (numIntroducido > numMax || numIntroducido < numMin) {
                    System.err.println("El numero introducido no es valido: " + numIntroducido + ", vuelve a intentarlo");
                }
                num[i] = numIntroducido;
            }
        } else {
            for (int i = 0; i < num.length; i++) {
                num[i] = aleatorio.nextInt(numMin,numMax+1);
            }
        }
        numReintegro = aleatorio.nextInt(numMin,numMaxReintegro+1);
        System.out.println("*** Estos son tus numeros de la suerte ***");
        System.out.println(Arrays.toString(num));
        System.out.println("*** Este es tu numero de reintegro ***");
        System.out.println(numReintegro);
    }
    /*
    El menu para llamar los metodos de los juegos
     */
    private static void menu() {
        do {
            System.out.println("*** Menu ***");
            System.out.println("*** Elige ***");
            System.out.println("*** 1. Juego único ***");
            System.out.println("*** 2. Jugar hasta obtener premio ***");
            System.out.println("*** 3. Jugar hasta obtener premio (sin reintegro) ***");
            System.out.println("*** 4. Ciclo de 10000 sorteos ***");
            System.out.println("*** 5. Jugar hasta obtener premio categoría especial ***");
            System.out.println("*** 0. Salir ***");
            numIntroducido = Integer.parseInt(leer.nextLine());

            /* Aqui van los metodos de los juegos
            switch (numIntroducido) {
                case 1 ->
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 ->
            }
            */
        } while (numIntroducido != 0);
        System.out.println("Adios...");
    }
}