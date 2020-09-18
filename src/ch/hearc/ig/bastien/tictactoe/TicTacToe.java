package ch.hearc.ig.bastien.tictactoe;

/*
 * TicTacToe game main class
 * This class is responsible of the game management
 * */
public class TicTacToe {

    Renderer renderer;
    Interaction interact;
    Grid grid;
    Player winner;

    Player pl1;
    Player pl2;

    int round;

    public TicTacToe() {
        this.renderer = new Renderer(new Display());
        this.interact = new Interaction(this.renderer);
        this.grid = new Grid();
    }

    /*
     * Start the game
     * */
    public void start() {

        renderer.bigMessage("Hello", "TicTacToe");

        // Create two players for the game
        pl1 = new Player('X');
        pl2 = new Player('O');
        // Set the round
        round = 1;

    }

    /*
     * Check if you can play a new round
     * */
    public boolean isPlayable() {
        try {
            // If there is a winner the game is finished
            this.winner = grid.hasWinner();
            return false;
        } catch (NoWinnerException e) {
            // If there is no winner, check if the grid is full or not
            return !grid.isFull();
        }
    }

    /*
     * Display the winner of the game
     * */
    public void showWinner() {
        // Show the state of the grid
        renderer.gameGrid(grid);
        // Display message for the winner
        if (this.winner != null) {
            renderer.bigMessage("THE WINNER IS :", "Player : " + winner.symbol, "In " + round + "rounds !");
        } else {
            renderer.bigMessage("Match ended in a draw after " + round + " rounds...", "Try again");
        }
    }

    /*
     * Start a new round
     * Do nothing if the game is terminated
     * */
    public void newRound() {

        // To store the ref to the player wo play this round
        Player roundPlayer;
        // Display the state of the grid
        renderer.gameGrid(grid);

        // Determine which player can play
        if (round % 2 == 1) {
            roundPlayer = pl1;
        } else {
            roundPlayer = pl2;
        }

        // Ask the next player move
        int caseNumber = interact.askNextMove(roundPlayer);

        // Check if the move is possible
        while (!grid.isPositionFree(grid.getX(caseNumber), grid.getY(caseNumber))) {
            renderer.simpleMessage("This case is already taken ! Try another...");
            caseNumber = interact.askNextMove(roundPlayer);
        }

        // Stores the player round choice in the grid
        grid.playPosition(
                grid.getX(caseNumber),
                grid.getY(caseNumber),
                roundPlayer
        );

        // Increase the round count
        round++;
    }
}
