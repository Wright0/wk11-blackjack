import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;

    @Before
    public void before(){
        deck = new Deck ();
    }

    @Test
    public void checkDeckHas52Cards(){
        assertEquals(52, deck.getCardArrayLength());
        assertEquals(true, deck.dealOneCard() instanceof Card);
    }

    @Test
    public void afterCardHasBeenDealtDeckHasOneLessCard(){
        deck.dealOneCard();
        assertEquals(51, deck.getCardArrayLength());
    }

}
