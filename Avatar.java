import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Avatar {
    private Card[] cards = new Card[40];

    public void readCardData() {
        for (int i = 0; i < 40; i++) {
            cards[i] = null;
        }
    }

    public void shuffle() {
        List<Card> card_list = Arrays.asList(this.cards);
		Collections.shuffle(card_list);
		card_list.toArray(this.cards);
    }

    public void draw() {
        ;
    }

    public void faceUp() {
        ;
    }

    public void faceDown() {
        ;
    }

    public void reset() {
        ;
    }
}
