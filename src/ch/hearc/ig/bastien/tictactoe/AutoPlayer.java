package ch.hearc.ig.bastien.tictactoe;

import java.util.Random;

public class AutoPlayer extends Player {

    private final Random random = new Random();
    private Renderer render;

    public AutoPlayer(char symbol, Renderer render) {
        super(symbol);
        this.render = render;
    }

    @Override
    public int playRound() {
        render.simpleMessage("Computer thinks about his next move...!");
        return random.nextInt(9) + 1;
    }


}
