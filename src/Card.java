import java.awt.*;
import java.util.Comparator;

public class Card implements Comparable<Card> {

    private Value cardValue;
    private Suit cardSuit;

    public Value getCardValue() {
        return cardValue;
    }

    public void setCardValue(Value cardValue) {
        this.cardValue = cardValue;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }

    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public Card(Value cardValue, Suit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    @Override
    public int compareTo(Card o) {
        return this.getCardValue().getCardValue();
    }

    Comparator<Card> compareById = new Comparator<Card>() {
        @Override
        public int compare(Card o1, Card o2) {
            return o1.getCardValue().compareTo(o2.getCardValue());
        }
    };

    public static <T> int compareValue(Card o1, Card o2) {
        return o1.getCardValue().compareTo(o2.getCardValue());
    }

    public static <T> int compareSuits(Card o1, Card o2) {
        return o1.getCardSuit().compareTo(o2.getCardSuit());
    }
    public static <T> int compareColor(Card o1, Card o2) {
        String cardColor1;
        if (o1.getCardSuit().getColor().equals(Color.RED))
            cardColor1 = "RED" ;
        else
            cardColor1 = "BLACK";
        String cardColor2;
        if (o2.getCardSuit().getColor().equals(Color.RED))
            cardColor2 = "RED" ;
        else
            cardColor2 = "BLACK";
        return cardColor1.compareTo(cardColor2);
    }
}
