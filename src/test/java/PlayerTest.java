import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck ();
        player1 = new Player("Catherine");
        player2 = new Player("Olivia");
    }

//    @Test
//    public void hasReceivedHand(){
//        player1.receiveCard(deck.dealOneCard());
//        assertEquals(true, player1.getHand() instanceof Card);
//    }
}
