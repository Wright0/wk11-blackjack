import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player olivia;
    private Player evelyn;
    private Deck deck;

    @Before
    public void before(){
        olivia = new Player("Olivia");
        evelyn = new Player("Evelyn");
        deck = new Deck();
        game = new Game(deck);
    }

    @Test
    public void canAddPlayerToGame(){
        game.addPlayer(olivia);
        assertEquals(1, game.getPlayerCount());
    }

    @Test //Surely there's a better way to test this... Same problem as in player test file.
    public void canGetArrayOfPlayers(){
        game.addPlayer(olivia);
        game.addPlayer(evelyn);
        ArrayList<Player> players = game.getPlayers();
        assertEquals(2, players.size());
    }

    @Test
    public void canDealCorrectNumberOfCardsAtStartOfGame(){
        game.addPlayer(olivia);
        game.dealToStartGame(2);
        assertEquals(2, olivia.getHand().size());
    }

    @Test
    public void playerCanTakeAnotherCard(){
        game.addPlayer(olivia);
        game.dealToStartGame(2);
        game.playerTwists(olivia);
        assertEquals(3, olivia.getHand().size());
    }



}
