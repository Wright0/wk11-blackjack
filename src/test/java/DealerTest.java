import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    Player player;
    Dealer dealer;
    Card card;
    Card card2;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.TWO);
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

    @Test
    public void canReturnDealersFirstCard(){
        dealer.receiveCard(card);
        dealer.receiveCard(card2);
        assertEquals(card, dealer.showFirstCardInHand());
    }
}
