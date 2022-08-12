import com.Card;
import com.Deck;

public class Main {
    public static void main(String[] args) {

        Deck deck = new Deck();

        System.out.println("Hay " + deck.cartasDisponibles() + " cartas disponibles.");

        deck.siguienteCarta();

        deck.darCartas(5);

        System.out.println("Hay " + deck.cartasDisponibles() + " cartas disponibles.");

        System.out.println("Cartas sacadas de momento.");

        deck.cartasMonton();

        deck.shuffle();

        deck.mostrarMano();

        Card[] c = deck.darCartas(5);

        System.out.println("Cartas sacadas despues de barajar.");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
