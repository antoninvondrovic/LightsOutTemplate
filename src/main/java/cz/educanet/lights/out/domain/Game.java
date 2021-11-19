package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

public class Game implements ILightsOut {

    int moves = 0;

    @Override
    public int getMoveCount() {
        return this.moves;
    }

    @Override
    public boolean isGameOver() {
        if (false) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean[][] getGrid() {
        return new boolean[5][5];
    }

    @Override
    public void makeMove(int x, int y) {
        moves++;
    }

}
