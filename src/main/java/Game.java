import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;

    public Game(Deck deck){
        this.players = new ArrayList<Player>();
        this.deck = deck;
    }
    
    public int getPlayerCount(){
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public void dealToStartGame(int numberOfCardsToDeal){
        for (Player player : this.players){
            for (int i = 0; i < numberOfCardsToDeal; i++) {
                Card card = deck.dealOneCard();
                player.receiveCard(card);
            }
        }
    }

    public void playerTwists(Player player){
        Card card = deck.dealOneCard();
        player.receiveCard(card);
    }



//    public Player returnWinner(){
//        if
//
//    }


}
