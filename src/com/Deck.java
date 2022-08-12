package com;
import com.Card;

import java.lang.reflect.Method;
import java.util.Random;

public class Deck {
    private Card cartas[];
    private int posSiguienteCarta;

    public static final int NUMERO_CARTA = 52;

    public Deck() {
        this.cartas = new Card[NUMERO_CARTA];
        this.posSiguienteCarta = 0;
        crearDeck();
        shuffle();
    }

    private void crearDeck() {
        String[] palos = Card.Palos;
        int contadorCartarCredas = 0;
        for (int i = 0; i < palos.length; i++) {
            for (int u = 0; u < Card.LIMITE_CARTA_PALO; u++) {
                cartas[contadorCartarCredas] = new Card(u + 1, palos[i]);
                ++contadorCartarCredas;
            }
        }
    }

    public void shuffle() {
        int posAleatorio = 0;
        Card c;

        for (int i = 0; i < cartas.length; i++) {
            posAleatorio = (int)(Math.random() * NUMERO_CARTA - 1);
            c = cartas[i];
            cartas[i] = cartas[posAleatorio];
            cartas[posAleatorio] = c;
        }
    }

    public Card siguienteCarta() {
        Card c = null;

        if(posSiguienteCarta == NUMERO_CARTA) {
            System.out.println("Ya no hay más cartas, barajea de nuevo el Deck.");
        } else{
            c = cartas[posSiguienteCarta++];
        }
        return c;
    }

    public Card[] darCartas(int numeroDeCarta) {

        if (numeroDeCarta > NUMERO_CARTA) {
            System.out.println("No se pueden dar más cartas de las que hay.");
            return null;
        } else{

            if(cartasDisponibles() < numeroDeCarta) {
                System.out.println("No hay suficientes cartas que mostrar.");
                return null;
            } else {
                Card[] cartasDar = new Card [numeroDeCarta];

                for(int i = 0; i < cartasDar.length; i++) {
                    cartasDar[i] = siguienteCarta();
                }
                return cartas;
            }
        }
    }

    public int cartasDisponibles() {
        return NUMERO_CARTA - posSiguienteCarta;
    }

    public void cartasMonton() {

        if(cartasDisponibles() == NUMERO_CARTA) {
            System.out.println("No se ha sacado ninguna carta.");
        } else{
            for(int i = 0; i < posSiguienteCarta; i++) {
                System.out.println(cartas[i]);
            }
        }
    }

    public void mostrarMano() {

        if (cartasDisponibles() == 0) {
            System.out.println("No hay cartas que mostrar.");
        } else {
            for (int i = 0; i < posSiguienteCarta; i++) {
                System.out.println(cartas[i]);
            }
        }
    }
}
