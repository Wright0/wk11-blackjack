public class Player {

    private String name;
    private Card cardInHand;

    public Player(String name){
        this.name = name;
        this.cardInHand = null;
    }

    public void receiveCard(Card card){
        this.cardInHand = card;
    }

    public Card getCard() {
        return this.cardInHand;
    }
}

