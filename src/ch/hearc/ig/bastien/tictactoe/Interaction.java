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
        this.input = new Scanner(System.in);
    }

    public int askNextMove(Player player) {
        this.renderer.simpleMessage("Whats your next move player " + player.symbol + " ? (insert case number)");
        return this.input.nextInt();
    }
}
