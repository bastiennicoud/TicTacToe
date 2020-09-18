package ch.hearc.ig.bastien.tictactoe;

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
