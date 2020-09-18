package ch.hearc.ig.bastien.tictactoe;

/**
 * Grid class manage the game class and provide methods to interact with the grid
 */
public class Grid {

    /**
     * Stores the Positions played
     */
    private Position[][] grid = new Position[3][3];

    /**
     * Grid constructor
     * Fill the grid with non played Position
     */
    public Grid() {
        // Fill each grid positions
        for (int x = 0; x < this.grid.length; x++) {
            for (int y = 0; y < this.grid.length; y++) {
                this.grid[y][x] = new Position();
            }
        }
    }

    public Position[][] getGrid() {
        return grid;
    }

    public void setGrid(Position[][] grid) {
        this.grid = grid;
    }

    /**
     * Check if a specific grid position is played
     */
    public boolean isPositionFree(int x, int y) {
        return !grid[y][x].isPlayed();
    }

    /**
     * Check if a specific grid position is played
     */
    public char symbolAtPosition(int x, int y) {
        if (grid[y][x].isEmpty()) {
            return ' ';
        } else {
            return grid[y][x].getPlayer().symbol;
        }
    }

    /**
     * Play in a position with a specific player
     */
    public void playPosition(int x, int y, Player player) {
        grid[y][x].setPlayer(player);
    }

    /**
     * Check if all the positions of the grid are played
     */
    public boolean isFull() {
        int i = 0;
        for (Position[] line : this.grid) {
            for (Position el : line) {
                if (el.isPlayed())
                    i++;
            }
        }

        // Check if there is 9 positions played
        return i >= 9;
    }

    /**
     * Check if there is a winner in the grid
     */
    public Player hasWinner() throws NoWinnerException {

        boolean flag;

        // Check lines
        for (Position[] line : this.grid) {
            flag = true;
            // Check if all the line elements are the same
            for (Position position : line) {
                if (position.isEmpty()) {
                    flag = false;
                } else if (line[0].getPlayer() != position.getPlayer()) {
                    flag = false;
                }
            }
            // If there is a winner line, we return the player who has won
            if (flag)
                return line[0].getPlayer();
        }

        // Check columns
        for (int c = 0; c < this.grid.length; c++) {
            flag = true;
            for (Position[] positions : this.grid) {
                // Check for each column (c) if each lines position are the same of the first line
                if (positions[c].isEmpty()) {
                    flag = false;
                } else if (this.grid[0][c].getPlayer() != positions[c].getPlayer()) {
                    flag = false;
                }
            }
            // If there is a winner column, we return the player
            if (flag)
                return this.grid[0][c].getPlayer();
        }

        // Check diagonal
        flag = true;
        for (int i = 0; i < this.grid.length; i++) {
            if (this.grid[i][i].isEmpty()) {
                flag = false;
            } else if (this.grid[0][0].getPlayer() != this.grid[i][i].getPlayer()) {
                flag = false;
            }
        }
        // If there is a winner in diagonal
        if (flag)
            return this.grid[0][0].getPlayer();

        // Check opposite diagonal
        flag = true;
        for (int x = 0; x < this.grid.length; x++) {
            int[] y = {2, 1, 0};
            if (this.grid[y[x]][x].isEmpty()) {
                flag = false;
            } else if (this.grid[2][0].getPlayer() != this.grid[y[x]][x].getPlayer()) {
                flag = false;
            }
        }
        // If there is a winner in opposite diagonal
        if (flag)
            return this.grid[2][0].getPlayer();

        // If there is no winner, the method exits wit noWinner exception
        throw new NoWinnerException();
    }

    /**
     * Determine the x coordinate from a case number
     */
    public int getX(int caseNumber) {
        int[] xCases = {0, 0, 1, 2, 0, 1, 2, 0, 1, 2};
        return xCases[caseNumber];
    }

    /**
     * Determine the y coordinate from a case number
     */
    public int getY(int caseNumber) {
        int[] yCases = {0, 0, 0, 0, 1, 1, 1, 2, 2, 2};
        return yCases[caseNumber];
    }
}
