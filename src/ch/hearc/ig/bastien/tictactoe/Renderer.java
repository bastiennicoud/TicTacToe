package ch.hearc.ig.bastien.tictactoe;

import java.util.ArrayList;

/**
 * Provides methods to generate strings for display from data's
 */
public class Renderer {

    Display display;

    public Renderer(Display display) {
        this.display = display;
    }

    /**
     * Render a simple line message
     */
    public void simpleMessage(String message) {
        display.renderLine(message);
    }

    /**
     * Render empty lines
     */
    public void emptyLines(int count) {
        for (int i = 0; i < count; i++) {
            display.renderLine("");
        }
    }

    /**
     * Display a multiline message with big heading and footer
     */
    public void bigMessage(String... message) {
        ArrayList<String> canvas = new ArrayList<>();

        canvas.add("****************************************");
        canvas.add("**");
        for (String l : message) {
            canvas.add("**  " + l);
        }
        canvas.add("**");
        canvas.add("****************************************");

        display.renderCanvas(canvas);
    }


    /**
     * Render the game grid in the console
     *
     * @param grid the new game grid to render
     */
    public void gameGrid(Grid grid) {
        ArrayList<String> canvas = new ArrayList<>();

        canvas.add("****************************************");
        canvas.add("**   Case number   **    Game grid    **");
        canvas.add("**                 **                 **");
        canvas.add("**    1 | 2 | 3    **    " + grid.symbolAtPosition(0, 0) + " | " + grid.symbolAtPosition(1, 0) + " | " + grid.symbolAtPosition(2, 0) + "    **");
        canvas.add("**   ---+---+---   **   ---+---+---   **");
        canvas.add("**    4 | 5 | 6    **    " + grid.symbolAtPosition(0, 1) + " | " + grid.symbolAtPosition(1, 1) + " | " + grid.symbolAtPosition(2, 1) + "    **");
        canvas.add("**   ---+---+---   **   ---+---+---   **");
        canvas.add("**    7 | 8 | 9    **    " + grid.symbolAtPosition(0, 2) + " | " + grid.symbolAtPosition(1, 2) + " | " + grid.symbolAtPosition(2, 2) + "    **");
        canvas.add("**                 **                 **");
        canvas.add("****************************************");

        display.renderCanvas(canvas);
    }
}
