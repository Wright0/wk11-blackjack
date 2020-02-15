import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScorerTest {

    private Card ace;
    private Card queen;
    private Player olivia;

    @Before
    public void before(){
        ace = new Card(Suit.HEARTS, Rank.ACE);
        queen = new Card(Suit.HEARTS, Rank.QUEEN);
        olivia = new Player("Olivia");
    }

    @Test
    public void canScoreHandCorrectly(){
        olivia.receiveCard(ace);
        olivia.receiveCard(queen);
        assertEquals(21, Scorer.scoreHand(olivia.getHand()));
    }

    @Test
    public void canReturnTrueIf21(){
        olivia.receiveCard(ace);
        olivia.receiveCard(queen);
        assertEquals(true, Scorer.checkIfBlackJack(olivia));
    }

    @Test
    public void canReturnFalseIfNot21(){
        olivia.receiveCard(ace);
        assertEquals(false, Scorer.checkIfBlackJack(olivia));
    }
}
