package ch.hearc.ig.bastien.tictactoe;

public abstract class Player {

    char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public abstract int playRound();
}
