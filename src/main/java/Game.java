import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Dealer dealer;

    public Game(Deck deck){
        this.players = new ArrayList<Player>();
        this.deck = deck;
        this.dealer = new Dealer("the dealer");
        this.deck.shuffleDeck();
    }
    
    public int getPlayerCount(){
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getPlayer(int index){
        return this.players.get(index);
    }

    public Dealer getDealer(){
        return this.dealer;
    }

    private Card dealCard(Player player){
        Card card = this.deck.dealOneCard();
        player.receiveCard(card);
        return card;
    }

    public void startGame(){
        for (Player player : this.players){
            for (int i = 0; i < 2; i++) {
                this.dealCard(player);
            }
        }
        for (int i = 0; i < 2; i++) {
            this.dealCard(this.dealer);
        }
    }

    public Card playerTwists(Player player){
        return dealCard(player);
    }

    public void dealerMoves(){
        while (dealer.canDealerPlay()){
            playerTwists(this.dealer);
            dealer.checkAndSetBustStatus();
        }
    }

    public boolean isBlackJack(Player player) {
        return Scorer.scoreHand(player) == 21;
    }


    public boolean isDraw(Player player) {
        return Scorer.scoreHand(player) == Scorer.scoreHand(this.dealer);
    }

    public Player returnWinner(){
        Player winner = null;
        int highScore = 0;
        int dealerScore = Scorer.scoreHand(dealer);

        for (Player player : this.players){
            int playerScore = Scorer.scoreHand(player);
            if (playerScore > highScore && playerScore < 22){
                winner = player;
                highScore = playerScore;
            }
        }

        if (dealerScore > highScore && dealerScore < 22){
            winner = this.dealer;
            highScore = dealerScore;
        }
        return winner;
    }


}
