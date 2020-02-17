import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Game game = new Game(deck);
        int playerCount = 0;
        Dealer dealer = game.getDealer();

        System.out.println(String.format("Hi! I'm %s the dealer. Let's play BlackJack!", dealer.getName() ));
        System.out.println("First, how many people are playing today?");

        String input = scanner.next();
        playerCount = parseInt(input);

        for (int i = 0; i < playerCount; i++){
            System.out.println(String.format("Okay, Player%d, What's your name?", i + 1));
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        System.out.println("Great! Looks like we're ready to go! Let me deal the cards.");

        game.startGame();

        System.out.println(String.format("My first card is a: %s.", dealer.showFirstCardInHand().getCardName()));

        for (int i = 0; i < playerCount; i++){
            Player activePlayer = game.getPlayer(i);
            Boolean playerTurnOver = false;
            Boolean isPlayerBust = false;

            System.out.println(String.format("%s, it's your turn.", activePlayer.getName()));

            for (Card card : activePlayer.getHand()){
                System.out.println(String.format("You have a: %s.", card.getCardName()));
            }

            while(!playerTurnOver && !isPlayerBust){
                System.out.println(String.format("Your current score is %d. Would you like to twist or stay? Lowercase please.", Scorer.scoreHand(activePlayer)));
                String nextMove = scanner.next();

                while (!"twist".equals(nextMove) && !"stay".equals(nextMove)){
                    System.out.println("Hmm I think you  a typo. Can you write that again? Twist or stay? Lowercase please!");
                    nextMove = scanner.next();
                }

                System.out.println(String.format("Great! You want to %s! Let's go:", nextMove));

                if ("twist".equals(nextMove)){
                    Card activeCard = game.playerTwists(activePlayer);
                    System.out.println(String.format("You got a: %s.", activeCard.getCardName()));
                    isPlayerBust = activePlayer.getPlayerBustStatus();
                    if (isPlayerBust){
                        System.out.println("Uh oh! Looks like you've bust!");
                    }
                } else {
                    playerTurnOver = true;
                    System.out.println("Okay! Let's keep going.");
                }
            }
        }

        game.dealerMoves();

        System.out.println("Time to reveal the winner! Here are my cards:");

        for (int i = 0; i < dealer.getHandSize(); i++){
            System.out.println(String.format("%s.", dealer.getHand().get(i).getCardName()));
        }

        System.out.println("Which means the final scores are...");

        for (int i = 0; i < game.getPlayerCount(); i++){
            Player activePlayer = game.getPlayer(i);

            if (game.getPlayer(i).getPlayerBustStatus()){
                System.out.println(String.format("%s went bust!", game.getPlayer(i).getName()));
            } else {
                System.out.println(String.format("%s has %d points.", activePlayer.getName(), Scorer.scoreHand(activePlayer)));
            }
        }
        if (dealer.getPlayerBustStatus()){
            System.out.println("I went Bust!");
        } else {
            System.out.println(String.format("I have %d points", Scorer.scoreHand(dealer)));
        }

        System.out.println(String.format("The winner is %s! Thanks for playing!", game.returnWinner().getName()));
    }
}