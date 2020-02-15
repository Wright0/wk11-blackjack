import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ScorerTest {

    private Card two;
    private Card three;
    private Player olivia;

    @Before
    public void before(){
        two = new Card(Suit.SPADES, Rank.TWO);
        three = new Card(Suit.HEARTS, Rank.THREE);
        olivia = new Player("Olivia");
    }

    @Test
    public void canScoreHandCorrectly(){
        olivia.receiveCard(two);
        olivia.receiveCard(three);
        assertEquals(5, Scorer.scoreHand(olivia.getHand()));
    }
}
