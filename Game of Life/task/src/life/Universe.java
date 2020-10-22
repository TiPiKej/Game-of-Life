package life;

import java.util.Random;

public class Universe {
    private boolean[][] area;
    private int size;
    private int alive;
    private int generation;

    public Universe(int size) {
        area = new boolean[size][size];
        this.size = size;
        alive = 0;
        generation = 1;
    }

    public Universe(int size, Long S) {
        area = new boolean[size][size];
        this.size = size;
        alive = 0;
        generation = 1;
        fill(S);
    }

    public void fill(Long seed) {
        Random random = new Random(seed);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                area[i][j] = random.nextBoolean();
                if (area[i][j]) alive++;
            }
        }
    }

    public void setArea(int x, int y, boolean state) {
        area[y][x] = state;
    }

    public boolean getAreaScf(int x, int y) {
        return area[y][x];
    }

    public int getSize() {
        return size;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }

    public int getAlive() {
        return alive;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getGeneration() {
        return generation;
    }

    public Universe copy() {
        Universe cpy = new Universe(size);
        cpy.generation = this.generation;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cpy.setArea(x, y, area[y][x]);
            }
        }
        cpy.alive = this.alive;

        return cpy;
    }

    public void update(Universe cpy) {
        this.alive = cpy.alive;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.setArea(x, y, cpy.getAreaScf(x, y));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append(String.format("Generation: #%d\n", generation));
        ret.append(String.format("Alive: %d\n\n", alive));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ret.append(area[i][j] ? "O" : " ");
            } ret.append("\n");
        }

        return ret.toString();
    }
}
