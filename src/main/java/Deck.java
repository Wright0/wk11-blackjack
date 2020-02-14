import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = createDeck();
    }

    public static ArrayList<Card> createDeck() {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

    public Card dealFirstCard() {
        Card cardDealt = this.cards.get(0);
        this.cards.remove(0);

        return cardDealt;
    }

    public int getCardArrayLength() {
        return this.cards.size();
    }

    public void shuffleDeck() {
       Collections.shuffle(this.cards);
    }
}

