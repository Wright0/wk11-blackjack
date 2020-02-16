public class Scorer {

    public static int scoreHand(Player player){
        int score = 0;

        for (Card card : player.getHand()){
            if (score < 10 && card.getRank() == Rank.ACE){
                score += 11;
            } else if (score > 10 && card.getRank() == Rank.ACE) {
                score += 1;
            } else if (card.isFaceCard()){
                score += 10;
            } else {
                score += card.getRank().ordinal() + 1;
            }
        }
        return score;
    }

    //The ace logic needs to be reworked because in the scenario where the ace is the first
    // card dealt you might want to switch it to a 1 later.

}
