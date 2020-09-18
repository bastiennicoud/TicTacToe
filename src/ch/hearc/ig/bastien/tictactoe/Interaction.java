package ch.hearc.ig.bastien.tictactoe;

import java.util.Scanner;

/*
 * Provides methods to interact with user in the console
 * */
public class Interaction {

    Renderer renderer;
    Scanner input;

    public Interaction(Renderer renderer) {
        this.renderer = renderer;
        // Initialize java scanner to get data's from console input
        this.input = new Scanner(System.in);
    }

    /*
     * Ask the user is next move
     * Return the grid case number from the user input
     * */
    public int askNextMove(Player player) {
        this.renderer.simpleMessage("Whats your next move player " + player.symbol + " ? (insert case number)");
        return this.input.nextInt();
    }
}
