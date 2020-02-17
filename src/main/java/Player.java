import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private Boolean isBust;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.isBust = false;
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

    public boolean isPlayerBust(){
        return this.isBust;
    }

    public void checkAndSetBustStatus(){
        if (Scorer.scoreHand(this) > 21) {
            this.isBust = true;
        }
    }

}