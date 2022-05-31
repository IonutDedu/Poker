import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> deck;

    private final int suitNumber = 4;
    private final int valueCount = 13;

    public void Deck() {
        deck = new ArrayList<>();
        Card card = null;
        for (int i = 0; i < valueCount; i++) {
            for (int j = 0; j < suitNumber; j++) {
                card = new Card(Value.values()[i], Suit.values()[j]);
                deck.add(card);
            }
        }
    }


    public List<Card> getDeck() {
        return deck;
    }
}
