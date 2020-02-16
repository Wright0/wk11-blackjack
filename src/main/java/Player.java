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

    public ArrayList<Card> getHand() {
        ArrayList<Card> copyOfHand = new ArrayList<Card>(this.hand);
        return copyOfHand;
    }

    public int getHandSize(){
        return this.hand.size();
    }

}