package com.primitiva.Juego;

public enum Premios{
    ESPECIAL("Premio especial"),
    PRIMERO("Primer premio"),
    SEGUNDO("Segundo premio"),
    TERCERO("Tercer premio"),
    CUARTO("Cuarto premio"),
    QUINTO("Quinto premio"),
    NINGUNO("No has ganado nada");

    private final String texto;


    Premios(String texto){
        this.texto = texto;
    }

    @Override
    public String toString(){
        return texto;
    }
}
