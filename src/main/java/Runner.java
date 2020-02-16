import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Game game = new Game(deck);
        int playerCount = 0;

        System.out.println(String.format("Hi! I'm %s the dealer. Let's play BlackJack!", game.getDealer().getName() ));
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

        System.out.println(String.format("My first card is a: %s.", game.getDealer().showFirstCardInHand().getCardName()));

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
                    System.out.println("Hmm I think you made a typo. Can you write that again? Twist or stay? Lowercase please!");
                    nextMove = scanner.next();
                }

                System.out.println(String.format("Great! You want to %s! Let's go:", nextMove));

                if ("twist".equals(nextMove)){
                    Card activeCard = game.playerTwists(activePlayer);
                    System.out.println(String.format("You got a: %s.", activeCard.getCardName()));
                    isPlayerBust = game.isplayerBust(activePlayer);
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

        for (int i = 0; i < game.getDealer().getHandSize(); i++){
            System.out.println(String.format("%s.", game.getDealer().getHand().get(i).getCardName()));
        }

        System.out.println("Which means...");

//       if (game.isDraw()){
//           System.out.println(String.format("It's a draw! We both have %d points.", Scorer.scoreHand(player)));
//       }





    }
}
