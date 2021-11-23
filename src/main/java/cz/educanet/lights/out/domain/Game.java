package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {

    private boolean[][] grid = new boolean[5][5];
    private boolean kok = false;
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
        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        if (grid[x][y]) {
            grid[x][y] = false;
            grid[x][y + 1] = false;
            grid[x][y - 1] = false;
            grid[x + 1][y] = false;
            grid[x - 1][y] = false;
            moves++;
        } else {
            if (grid[x][y+1] = false) {
                System.out.println("kokot");
                grid[x][y] = true;
            }
            grid[x][y] = true;
            grid[x][y + 1] = true;
            grid[x][y - 1] = true;
            grid[x + 1][y] = true;
            grid[x - 1][y] = true;
            moves++;
        }
    }

    @Override
    public void randomize() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                Random rd = new Random();
                grid[x][y] = rd.nextBoolean();
            }
        }
    }
}
