import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScorerTest {

    private Card ace;
    private Card queen;
    private Player olivia;
    private Dealer dealer;

    @Before
    public void before(){
        ace = new Card(Suit.HEARTS, Rank.ACE);
        queen = new Card(Suit.HEARTS, Rank.QUEEN);
        olivia = new Player("Olivia");
        dealer = new Dealer("Bob");
    }

    @Test
    public void canScoreHandCorrectly(){
        olivia.receiveCard(ace);
        olivia.receiveCard(queen);
        assertEquals(21, Scorer.scoreHand(olivia));
    }

}
