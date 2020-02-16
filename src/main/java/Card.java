public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Rank getRank(){
        return this.rank;
    }

    public boolean isFaceCard() {
        return this.rank.getIsFaceCard();
    }

    public String getCardName(){
        return String.format("%s of %s", this.rank, this.suit);
            }
}
