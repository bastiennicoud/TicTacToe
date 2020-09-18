package ch.hearc.ig.bastien.tictactoe;

/**
 * The Position class represent a specific position in the Grid
 * Position provides logic to interact with the positions in the grid
 */
public class Position {

    /**
     * Memorize which player have played this position
     * If the player is empty, the position is not played
     */
    private Player player;

    public Position() {
    }

    public Position(Player player) {
        this.player = player;
    }

    /**
     * Check if this position have been played
     */
    public boolean isPlayed() {
        return this.player != null;
    }

    /**
     * Check if this position is not played
     */
    public boolean isEmpty() {
        return this.player == null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
