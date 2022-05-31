import java.awt.*;

public enum Suit {
    CLUBS("Clubs", Color.BLACK), DIAMONDS("Diamonds", Color.RED),
    HEARTS("Hearts", Color.RED), SPADES("Spades", Color.BLACK);

    private final String name ;
    private final Color color;

    Suit (String name, Color color){
        this.name = name;
        this.color=color;
    }

    public String getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }
}
