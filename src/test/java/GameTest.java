import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player olivia;
    private Player evelyn;
    private Deck deck;
    private Dealer dealer;
    private Card ace;
    private Card queen;

    @Before
    public void before(){
        olivia = new Player("Olivia");
        evelyn = new Player("Evelyn");
        dealer = new Dealer("Bob");

        deck = new Deck();
        game = new Game(deck);

        ace = new Card(Suit.HEARTS, Rank.ACE);
        queen = new Card(Suit.HEARTS, Rank.QUEEN);
    }

    @Test
    public void gameStartsWithDealer(){
        assertEquals("Bob", game.getDealer().getName());
    }

    @Test
    public void canAddPlayerToGame(){
        game.addPlayer(olivia);
        assertEquals(1, game.getPlayerCount());
    }

    @Test
    public void canGetArrayOfPlayers(){
        game.addPlayer(olivia);
        game.addPlayer(evelyn);
        assertEquals(2, game.getPlayerCount());
    }

    @Test
    public void canDealCorrectNumberOfCardsAtStartOfGame(){
        game.addPlayer(olivia);
        game.startGame();
        assertEquals(2, olivia.getHand().size());
        assertEquals(2, game.getDealer().getHand().size());
    }

    @Test
    public void playerCanTakeAnotherCard(){
        game.addPlayer(olivia);
        game.startGame();
        game.playerTwists(olivia);
        assertEquals(3, olivia.getHand().size());
    }

    @Test
    public void canReturnTrueIf21(){
        olivia.receiveCard(ace);
        olivia.receiveCard(queen);
        assertEquals(true, game.isBlackJack(olivia));
    }

    @Test
    public void canReturnFalseIfNot21(){
        olivia.receiveCard(ace);
        assertEquals(false, game.isBlackJack(olivia));
    }

    @Test
    public void canReturnFalseIfNotBust(){
        olivia.receiveCard(ace);
        assertEquals(false, game.isplayerBust(olivia));
    }

    @Test
    public void canReturnTrueIfBust(){
        olivia.receiveCard(ace);
        olivia.receiveCard(ace);
        assertEquals(true, game.isplayerBust(olivia));
    }

    @Test
    public void canReturnTrueWhenDraw(){
        olivia.receiveCard(ace);
        dealer.receiveCard(ace);
        assertEquals(true, game.isDraw(olivia));
    }

    @Test
    public void willReturnFalseWhenNotDraw(){
        olivia.receiveCard(ace);
        dealer.receiveCard(ace);
        dealer.receiveCard(ace);
        assertEquals(false, game.isDraw(olivia));
    }

    @Test
    public void willReturnCorrectWinner(){
        game.addPlayer(olivia);
        game.addPlayer(evelyn);
        olivia.receiveCard(ace);
        evelyn.receiveCard(ace);
        evelyn.receiveCard(queen);
        dealer.receiveCard(ace);
        assertEquals(evelyn, game.returnWinner());
    }

}
