package com.primitiva;

import java.time.LocalDateTime;

public class Sorteo {

    private final Bombo bomboPrincipal;
    private final Bombo bomboReintegro;

    public Sorteo(int numBolasPrincipal, int numBolasReintegro) {
        this.bomboPrincipal = new Bombo(numBolasPrincipal);
        this.bomboReintegro = new Bombo(numBolasReintegro);
    }

    // Generar una nueva combinación
    public int[] generarCombinacion() {
        return bomboPrincipal.sacarNumeros(6); // combinacion ganadora del primer bombo de 49
    }

    // Generar complementario
    public int generarComplementario() {
        return bomboPrincipal.sacarUnNumero(); // un numero que debe ser de los 44 restantes no puede ser igual a los 6 de la combinacion

    }

    // Generar reintegro
    public int generarReintegro() {
        return bomboReintegro.sacarUnNumero(); // del segundo bombo puede ser el que sea de 0 a 9
    }

    // Aqui podemos aprovechar si no queremos guardar cada resultado , sobrescribimos uno para lo de
    // jugar hasta ganar
    // quizas en la modalidad de jugar hasta ganar un array de de premios que vas obteniendo antes de
    // reiniciarlo
    //
    public void repeatSorteo(ResultadoSorteo resultado) {
        reiniciarBombos();
        resultado.setCombinacion(generarCombinacion());
        resultado.setComplementario(generarComplementario());
        resultado.setReintegro(generarReintegro());
        resultado.setFechaHora(LocalDateTime.now());
    }

    // Aqui generamos un sorteo , pero no seria optimo generar MUCHISIMOS para lo de jugar hasta
    // ganar,
    // aqui con los getters puedes comparar facil con el Boleto entrante mireya

    public ResultadoSorteo generarSorteo() {
        reiniciarBombos();
        int[] combinacion = generarCombinacion();
        int complementario = generarComplementario();
        int reintegro = generarReintegro();
        return new ResultadoSorteo(combinacion, complementario, reintegro);
    }

    // Solo reiniciar los bombos es decir las bolas , no podemos hacer mas sorteos justos si no
    // agitamos los arrays de bolas de posiciom
    public void reiniciarBombos() {
        bomboPrincipal.reiniciarBolas();
        bomboReintegro.reiniciarBolas();
    }
}
