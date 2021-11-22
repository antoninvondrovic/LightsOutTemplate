package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

public class Game implements ILightsOut {

    private boolean[][] grid = new boolean[5][5];
    private boolean retard = true;
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
            if (retard) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        grid[i][j] = true;
                    }
                }
                retard = false;
            }
            return false;
        }
    }

    @Override
    public boolean[][] getGrid() {
        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        if(grid[x][y] = false) {
            System.out.println("false");
            grid[x][y] = true;
        } else if (grid[x][y] = true){
            System.out.println("true");
            grid[x][y] = false;
        }
        moves++;
    }

}
