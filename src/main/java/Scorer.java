public class Scorer {

    public static int scoreHand(Player player){
        int score = 0;
        for (Card card : player.getHand()){
            score += CardValueGenerator.getCardScore(card);
        }
        return score;
    }

}
