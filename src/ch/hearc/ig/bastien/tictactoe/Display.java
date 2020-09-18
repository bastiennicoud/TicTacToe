package ch.hearc.ig.bastien.tictactoe;

import java.util.ArrayList;

/**
 * Simplify access for displaying things
 */
public class Display {

    /**
     * Render a canvas to the console
     */
    public void renderCanvas(ArrayList<String> canvas) {
        // Iterates trough the canvas and display each lines
        for (String line : canvas) {
            System.out.println(line);
        }
    }

    /**
     * Render a simple line to the console
     */
    public void renderLine(String line) {
        System.out.println(line);
    }
}
