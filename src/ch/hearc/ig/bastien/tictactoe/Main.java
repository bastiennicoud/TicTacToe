package ch.hearc.ig.bastien.tictactoe;

public class Main {

    public static void main(String[] args) {

        // Create a new tictactoe game
        TicTacToe game = new TicTacToe();

        // Tell the game to start (bas values initialisation)
        game.start();

        // Start the game loop, you can play a new round while the game is not terminated
        while (game.isPlayable()) {

            game.newRound();

        }

        // End of the game, show the winner
        game.showWinner();
    }
}
