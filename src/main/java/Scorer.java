import java.util.ArrayList;

public class Scorer {

    public static int scoreHand(ArrayList<Card> hand){
        int score = 0;
        for (Card card : hand){
            score += CardValueGenerator.getCardScore(card);
        }
        return score;
    }
}
