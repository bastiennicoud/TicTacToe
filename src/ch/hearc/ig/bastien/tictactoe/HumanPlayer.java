package ch.hearc.ig.bastien.tictactoe;


/**
 * A human player
 */
public class HumanPlayer extends Player {

    Interaction interact;

    public HumanPlayer(char symbol, Interaction interact) {
        super(symbol);
        this.interact = interact;
    }

    @Override
    public int playRound() {
        return interact.askNextMove(this);
    }

}
