package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {

    private boolean[][] grid = new boolean[5][5];
    int moves = 0;

    @Override
    public int getMoveCount() {
        return this.moves;
    }

    @Override
    public boolean isGameOver() {
        int counter = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (!grid[x][y]) {
                    counter++;
                }
            }
        }
        if (counter == 25) {
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
        int left = x - 1;
        int right = x + 1;
        int up = y - 1;
        int down = y + 1;
        int gs = grid.length - 1; // grid size, 4 by default with a boolean 2d arr of 5,5

        if (left >= 0 && right <= gs && up >= 0 && down <= gs) { //* the middle
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y - 1] = !grid[x][y - 1]; // up
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (left < 0 && up < 0) { //* left up corner
            grid[x][y] = !grid[x][y]; // middle
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (right > gs && up < 0) { //* right up corner
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (left < 0 && up >= 0 && down <= gs) { //* left side
            grid[x][y] = !grid[x][y]; // middle
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y - 1] = !grid[x][y - 1]; // up
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (up < 0 && left >= 0 && right <= gs) { //* up side
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (left < 0 && down > gs) { //* left down corner
            grid[x][y] = !grid[x][y]; // middle
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y - 1] = !grid[x][y - 1]; // up
        }
        if (right > gs && down > gs) { //* right down corner
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x][y - 1] = !grid[x][y - 1]; // up
        }
        if (right > gs && down <= gs && up >= 0) { //* right side
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x][y - 1] = !grid[x][y - 1]; // up
            grid[x][y + 1] = !grid[x][y + 1]; // down
        }
        if (down > gs && right <= gs && left >= 0) { //* down side
            grid[x][y] = !grid[x][y]; // middle
            grid[x - 1][y] = !grid[x - 1][y]; // left
            grid[x + 1][y] = !grid[x + 1][y]; // right
            grid[x][y - 1] = !grid[x][y - 1]; // up
        }


        System.out.println("X: " + x + " | Y: " + y);
        System.out.println("Left: " + left);
        System.out.println("Up: " + up);
        System.out.println("Right: " + right);
        System.out.println("Down: " + down);
        moves++;
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
