import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Player player;
    Dealer dealer;
    Card card;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.ACE);
        player = new Player("Olivia");
        dealer = new Dealer("Dealer");
    }

    @Test
    public void canReturnName(){
        assertEquals("Dealer", dealer.getName());
    }

    @Test
    public void dealerCanHaveHand(){
        dealer.receiveCard(card);
        assertEquals(1, dealer.getHand().size());
    }

    @Test
    public void willReturnFalseIfScoreOver16(){
        dealer.receiveCard(card);
        dealer.receiveCard(card);
        assertEquals(false, dealer.canDealerPlay());
    }

    @Test
    public void willReturnTrueIfScoreUnder16(){
        dealer.receiveCard(card);
        assertEquals(true, dealer.canDealerPlay());
    }
}
