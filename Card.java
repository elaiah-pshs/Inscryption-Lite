import java.util.ArrayList;

public class Card {
    protected int cost;
    protected Faces face_revealed = Faces.TOP;

    private enum Faces {
        TOP, BOTTOM;
    }

    public Card(int c) {
        this.cost = c;
    }

    public int getCost() {
        return cost;
    }

    public void faceUp() {
        face_revealed = Faces.TOP;
    }

    public void faceDown() {
        face_revealed = Faces.BOTTOM;
    }
}
