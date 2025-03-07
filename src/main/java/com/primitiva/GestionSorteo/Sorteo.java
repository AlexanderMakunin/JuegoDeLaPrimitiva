package com.primitiva.GestionSorteo;


public class Sorteo {
    private int[] resultado;
    private int complementario;
    private int reintegro;

    private final Bombo bomboPrincipal;
    private final Bombo bomboReintegro;

    public Sorteo(Bombo bomboPrincipal, Bombo bomboReintegro) {
        this.bomboPrincipal = bomboPrincipal;
        this.bomboReintegro = bomboReintegro;
        this.resultado = new int[6]; // Array reutilizable
    }

    public void generar() {
        bomboPrincipal.reiniciarBolas(); // Reinicia el bombo para cada sorteo
        bomboPrincipal.sacarNumerosEnArray(resultado, 6); // Genera los 6 números principales
        complementario = bomboPrincipal.sacarUnNumero(); // Genera el complementario
        reintegro = bomboReintegro.sacarUnNumero(); // Genera el reintegro
    }

    //mireya para el de hasta encontrar el premio especial, solo guarda esta referencia en un static o algo y la vas actualizando en cada iteracion que hagas generar(), para evitar crear muchos objetos
    public int[] getResultado() {
        return resultado;
    }

    public int getComplementario() {
        return complementario;
    }

    public int getReintegro() {
        return reintegro;
    }

    /**
     * @return devuelve un Resultado inmutable en caso de ser necesario, como para devolver el resultado ganador .
     */
    public ResultadoSorteo getResultadoGanador() {
        return new ResultadoSorteo(resultado, complementario, reintegro);
    }
}