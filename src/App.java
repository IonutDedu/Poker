import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int n = 1_000_000;  // how many times we shuffle and draw 5 cards
        int royalFlush = 0;
        int straightFlush = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int flush = 0;
        int straight = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int pairOfAce = 0;
        int pairOfKing = 0;
        int pairOfQueen = 0;
        int pairOfJack = 0;
        int pairOfTen = 0;
        //int nothing = 0; // for testing

        Deck deck = new Deck();
        deck.Deck();
        List<Card> myDeck = deck.getDeck();
        List<Card> pull5 = new ArrayList<>(); //draw5(myDeck);

        for (int i = 0; i < n; i++) {
            Collections.shuffle(myDeck);
            pull5 = draw5(myDeck);
            if (isRoyalFlush(pull5)) {
                royalFlush++;
                continue;
            }
            if (isStraightFlush(pull5)) {
                straightFlush++;
                continue;
            }
            if (isFourOfAKind(pull5)) {
                fourOfAKind++;
                continue;
            }
            if (isFullHouse(pull5)) {
                fullHouse++;
                continue;
            }
            if (testSuit(pull5)) {
                flush++;
                continue;
            }
            if (isStraight(pull5)) {
                straight++;
                continue;
            }
            if(isThreeOfAKind(pull5)){
                threeOfAKind++;
                continue;
            }
            if(isTwoPair(pull5)){
                twoPair++;
                continue;
            }
            if(isPairOfAce(pull5)){
                pairOfAce++;
                continue;
            }
            if(isPairOfKing(pull5)){
                pairOfKing++;
                continue;
            }
            if(isPairOfQueen(pull5)){
                pairOfQueen++;
                continue;
            }
            if(isPairOfJack(pull5)){
                pairOfJack++;
                continue;
            }
            if(isPairOfTen(pull5)){
                pairOfTen++;
                // continue; // for testing
            }
           // else nothing++; // for testing
        }

        System.out.println("The results are: \n" );
        System.out.println("Royal flush: " + royalFlush);
        System.out.println("Straight flush: " + straightFlush);
        System.out.println("Four of a kind: " + fourOfAKind);
        System.out.println("Full house: " + fullHouse);
        System.out.println("Flush: " + flush);
        System.out.println("Straight: " + straight);
        System.out.println("Three of a kind: " + threeOfAKind);
        System.out.println("Two pair: " + twoPair);
        System.out.println("Pair of Ace: " + pairOfAce);
        System.out.println("Pair of King: " + pairOfKing);
        System.out.println("Pair of Queen: " + pairOfQueen);
        System.out.println("Pair of Jack: " + pairOfJack);
        System.out.println("Pair of Ten: " + pairOfTen);
        //System.out.println("Nothing... "+ nothing); // for testing

     /*   showDeck(myDeck);
        System.out.println();
        pull5 = draw5(myDeck);
        //showDeck(pull5);
        showDeck(pull5);
        System.out.println();
        Collections.shuffle(myDeck);
        showDeck(myDeck);
        System.out.println();
        pull5 = draw5(myDeck);
        showDeck(pull5);
        System.out.println(testColor(pull5));
        System.out.println(testSuit(pull5));
*/

    }

    private static void showDeck(List<Card> myDeck) {
        for (Card card : new ArrayList<>(myDeck)
        ) {
            String cardColor;
            if (card.getCardSuit().getColor().equals(Color.RED))
                cardColor = "RED";
            else
                cardColor = "BLACK";
            System.out.println(card.getCardValue() + " " + card.getCardValue().getCardValue() + " "
                    + card.getCardSuit() + " " + cardColor);   //card.getCardSuit().getColor());
        }
    }

    private static List<Card> draw5(List<Card> myDeck) {
        List<Card> drawn = new ArrayList<>();
        drawn.add(myDeck.get(0));
        drawn.add(myDeck.get(1));
        drawn.add(myDeck.get(2));
        drawn.add(myDeck.get(3));
        drawn.add(myDeck.get(4));
        Collections.sort(drawn, Card::compareColor);
        Collections.sort(drawn, Card::compareSuits);
        Collections.sort(drawn, Card::compareValue);
        return drawn;
    }

    public static boolean testColor(List<Card> pull5) {
        int testRed = 0;
        int testBlack = 0;
        for (Card card : pull5
        ) {
            if (card.getCardSuit().getColor().equals(Color.RED))
                testRed++;
            else
                //if(card.getCardSuit().getColor().equals(Color.BLACK))
                testBlack++;
        }
        if (testRed == 5)
            return true;
        if (testBlack == 5)
            return true;
        else
            return false;
    }

    public static boolean testSuit(List<Card> pull5) {
        int hearts = 0;
        int clubs = 0;
        int spades = 0;
        int diamonds = 0;
        for (Card card : pull5
        ) {
            if (card.getCardSuit().getName().equalsIgnoreCase("HEARTS"))
                hearts++;
            if (card.getCardSuit().getName().equalsIgnoreCase("CLUBS"))
                clubs++;
            if (card.getCardSuit().getName().equalsIgnoreCase("SPADES"))
                spades++;
            if (card.getCardSuit().getName().equalsIgnoreCase("DIAMONDS"))
                diamonds++;
        }
        if (hearts == 5 || clubs == 5 || spades == 5 || diamonds == 5)
            return true;
        else
            return false;
    }

    public static boolean isRoyalFlush(List<Card> pull5) {
        return pull5.get(0).getCardValue().getCardValue() == 1 &&
                pull5.get(1).getCardValue().getCardValue() == 10 &&
                pull5.get(2).getCardValue().getCardValue() == 11 &&
                pull5.get(3).getCardValue().getCardValue() == 12 &&
                pull5.get(4).getCardValue().getCardValue() == 13 &&
                testSuit(pull5) && testColor(pull5);
    }

    public static boolean isStraightFlush(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        return card1 + 4 == card5 && card2 + 3 == card5 &&
                card3 + 2 == card5 && card4 + 1 == card5 &&
                testColor(pull5) && testSuit(pull5);
    }

    public static boolean isFourOfAKind(List<Card> pull5) {
       /* int four = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++)
                if (pull5.get(i).getCardValue().getCardValue() == pull5.get(j).getCardValue().getCardValue() && i != j)
                    four++;
        }
        return four == 4;   */
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        return card1 == card2 && card2 == card3 && card3 == card4 ||
                // card1 == card2 && card2 == card3 && card3 == card5 ||
                // card1 == card2 && card2 == card4 && card4 == card5 ||
                // card1 == card3 && card3 == card4 && card4 == card5 ||
                card2 == card3 && card3 == card4 && card4 == card5;
    }

    public static boolean isFullHouse(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        if (card1 == card2 && card2 == card3 && card4 == card5)
            return true;
        return card1 == card2 && card3 == card4 && card4 == card5;
    }

    public static boolean isStraight(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        return card1 + 4 == card5 && card2 + 3 == card5 &&
                card3 + 2 == card5 && card4 + 1 == card5 &&
                !testColor(pull5) && !testSuit(pull5);
    }

    public static boolean isThreeOfAKind(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        return card1 == card2 && card2 == card3 ||
                card3 == card4 && card4 == card5;
    }

    public static boolean isTwoPair(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        int card3 = pull5.get(2).getCardValue().getCardValue();
        int card4 = pull5.get(3).getCardValue().getCardValue();
        int card5 = pull5.get(4).getCardValue().getCardValue();
        return card1 == card2 && card3 == card4 ||
                card1 == card2 && card4 == card5 ||
                card2 == card3 && card4 == card5;
    }

    public static boolean isPairOfAce(List<Card> pull5) {
        int card1 = pull5.get(0).getCardValue().getCardValue();
        int card2 = pull5.get(1).getCardValue().getCardValue();
        return card1 == 1 && card2 == 1;
    }

    public static boolean isPairOfKing(List<Card> pull5) {
        int kings = 0;
        for (Card card : pull5
        ) {
            if (card.getCardValue().getCardValue() == 13)
                kings++;
        }
        return kings == 2;
    }

    public static boolean isPairOfQueen(List<Card> pull5) {
        int queen = 0;
        for (Card card : pull5
        ) {
            if (card.getCardValue().getCardValue() == 12)
                queen++;
        }
        return queen == 2;
    }

    public static boolean isPairOfJack(List<Card> pull5) {
        int jack = 0;
        for (Card card : pull5
        ) {
            if (card.getCardValue().getCardValue() == 11)
                jack++;
        }
        return jack == 2;
    }

    public static boolean isPairOfTen(List<Card> pull5) {
        int ten = 0;
        for (Card card : pull5
        ) {
            if (card.getCardValue().getCardValue() == 10)
                ten++;
        }
        return ten == 2;
    }
}
