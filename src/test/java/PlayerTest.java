import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player1;
    Player player2;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck ();
        player1 = new Player("Evelyn");
        player2 = new Player("Olivia");
    }

    @Test
    public void canGetName(){
        assertEquals("Olivia", player2.getName());
    }

    @Test
    public void hasReceivedHand(){
        player1.receiveCard(deck.dealOneCard());
        assertEquals(1, player1.getHand().size());
    }

    //instanceof no longer works here because you can't use custom types for the comparison
    // other ways to check the data type that
}
