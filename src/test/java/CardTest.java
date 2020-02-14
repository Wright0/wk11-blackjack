import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

        Card card;

    @Before
    public void before(){
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void checkCardHasSuit(){
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void checkCardHasRank(){
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void checkIfCardIsFaceCard(){
        assertEquals(false, card.isFaceCard());
    }

}
