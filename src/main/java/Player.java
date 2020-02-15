import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public String getName(){
        return this.name;
    }

    public void receiveCard(Card card){
        this.hand.add(card);
    }

    //BAD! This array could be mutated. Rethink this.
    public ArrayList<Card> getHand() {
        return this.hand;
    }

}