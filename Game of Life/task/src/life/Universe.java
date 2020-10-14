package life;

import java.util.Random;

public class Universe {
    private boolean[][] area;
    private int size;

    public Universe(int size) {
        area = new boolean[size][size];
        this.size = size;
    }

    public Universe(int size, Long S) {
        area = new boolean[size][size];
        this.size = size;
        fill(S);
    }

    public void fill(Long seed) {
        Random random = new Random(seed);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                area[i][j] = random.nextBoolean();
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

    public Universe copy() {
        Universe cpy = new Universe(size);

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                cpy.setArea(x, y, area[y][x]);
            }
        }

        return cpy;
    }

    public void update(Universe cpy) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.setArea(x, y, cpy.getAreaScf(x, y));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ret.append(area[i][j] ? "O" : " ");
            } ret.append("\n");
        }

        return ret.toString();
    }
}
