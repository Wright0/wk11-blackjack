public class CardValueGenerator {

    public static int getCardScore(Card card){
        int value = 0;
        if (card.getRank() == Rank.ACE){
            value = 11;
        } else if (card.isFaceCard()){
            value = 10;
        } else {
            value = card.getRank().ordinal() + 1;
        }
        return value;
    }
}
