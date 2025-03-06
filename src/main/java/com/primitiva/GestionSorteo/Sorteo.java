package com.primitiva.GestionSorteo;

import java.time.LocalDateTime;

/**
 * La clase {@code Sorteo} representa un sorteo de La Primitiva.
 * Se encarga de gestionar los bombos, generar combinaciones ganadoras,
 * números complementarios y reintegros. También ofrece métodos para
 * repetir el sorteo y generar resultados.
 */
public class Sorteo {

    private final Bombo bomboPrincipal;
    private final Bombo bomboReintegro;

    /**
     * Constructor de la clase {@code Sorteo}.
     *
     * @param bomboPrincipal  El bombo principal del sorteo (números del 1 al 49).
     * @param bomboReintegro El bombo para el reintegro (números del 0 al 9).
     */
    public Sorteo(Bombo bomboPrincipal, Bombo bomboReintegro) {
        if (bomboPrincipal == null || bomboReintegro == null) {
            throw new IllegalArgumentException("Los bombos no pueden ser nulos.");
        }
        this.bomboPrincipal = bomboPrincipal;
        this.bomboReintegro = bomboReintegro;
    }

    /**
     * Genera una nueva combinación ganadora extrayendo 6 números del bombo principal.
     *
     * @return Un array de enteros de tamaño 6 que representa la combinación ganadora.
     */
    public int[] generarCombinacion() {
        return bomboPrincipal.sacarNumeros(6); // combinacion ganadora del primer bombo de 49
    }

    /**
     * Genera el número complementario, que es un número adicional extraído del bombo principal
     * después de haber extraído la combinación ganadora. El número complementario no puede estar
     * incluido en la combinación ganadora.
     *
     * @return El número complementario.
     */
    public int generarComplementario() {
        return bomboPrincipal.sacarUnNumero(); // un numero que debe ser de los 43 restantes no puede ser igual a los 6 de la combinacion
    }

    /**
     * Genera el reintegro extrayendo un número del bombo de reintegro.
     *
     * @return El número de reintegro.
     */
    public int generarReintegro() {
        return bomboReintegro.sacarUnNumero(); // del segundo bombo puede ser el que sea de 0 a 9
    }

    /**
     * Repite un sorteo utilizando el objeto {@code ResultadoSorteo} proporcionado.  Reinicia los bombos,
     * genera nueva combinación, complementario y reintegro y actualiza el objeto
     * {@code ResultadoSorteo} con los nuevos valores .  Este método se puede utilizar
     * en escenarios como "jugar hasta ganar" donde no es necesario almacenar todos los resultados,
     * sino sobrescribir uno existente.
     *
     * @param resultado El objeto {@code ResultadoSorteo} que se actualizará con los nuevos resultados.
     */
    public void repeatSorteo(ResultadoSorteo resultado) {  //Mireya para generar hasta ganar el sorteo especial es una locura , aqui no creo nuevos resultados si no que actualizamos uno y vas extrayendo la info entre iteracion.
        if (resultado == null) {
            throw new IllegalArgumentException("El resultado no puede ser nulo.");
        }
        reiniciarBombos();
        resultado.setCombinacion(generarCombinacion());
        resultado.setComplementario(generarComplementario());
        resultado.setReintegro(generarReintegro());
        resultado.setFechaHora(LocalDateTime.now());
    }

    /**
     * Genera un nuevo sorteo, creando un objeto {@code ResultadoSorteo} con la combinación,
     * complementario y reintegro generados.
     *
     * @return Un nuevo objeto {@code ResultadoSorteo} con los resultados del sorteo.
     */
    public ResultadoSorteo generarSorteo() {  //@Mireya este lo puedes usar para las 10k mientras que no los guardes sus referencias, solo aumentes tu contador de precios, el GB collector los borrara.
        reiniciarBombos();
        int[] combinacion = generarCombinacion();
        int complementario = generarComplementario();
        int reintegro = generarReintegro();
        return new ResultadoSorteo(combinacion, complementario, reintegro);
    }

    /**
     * Reinicia los bombos, es decir regenera y mezcla las bolas del bombo
     */
    private void reiniciarBombos() {
        bomboPrincipal.reiniciarBolas();
        bomboReintegro.reiniciarBolas();
    }
}