package com;

public class Card {
    private int numero;
    private String palo;

    public static final String[] Palos = {"Treboles", "Corazones", "Picas", "Diamantes"};
    public static final int LIMITE_CARTA_PALO = 13;



    public Card (int numero, String palo) {
        this.numero = (numero);
        this.palo = (palo);
    }

    public String toString() {
        return "numero=" + numero + ", palo=" + palo;
    }
}
