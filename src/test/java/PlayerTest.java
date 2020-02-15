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

    //Instance of no longer works. Can't use custom types and need an ArrayList<Card>.
    //Need to think of a new way to test this.
//    @Test
//    public void hasReceivedHand(){
//        player1.receiveCard(deck.dealOneCard());
//        assertEquals(true, player1.getHand() instanceof ArrayList<Card>);
//    }
}
