import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardValueGeneratorTest {

    Card ace;
    Card queen;
    Card seven;

    @Before
    public void before(){
        ace = new Card(Suit.SPADES, Rank.ACE);
        queen = new Card(Suit.HEARTS, Rank.QUEEN);
        seven = new Card(Suit.SPADES, Rank.SEVEN);

    }

    @Test
    public void canReturnCorrectCardValue(){
        assertEquals(11, CardValueGenerator.getCardScore(ace));
        assertEquals(10, CardValueGenerator.getCardScore(queen));
        assertEquals(7, CardValueGenerator.getCardScore(seven));
    }

}
