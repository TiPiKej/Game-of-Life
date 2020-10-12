package life;

import java.util.Random;

public class Game {
    private boolean[][] area;
    private int N;
    private int seed;

    public Game() {
        area = new boolean[0][0];
        N = 0;
        seed = 0;
        fill();
    }

    public Game(int N) {
        area = new boolean[N][N];
        this.N = N;
        this.seed = 0;
        fill();
    }

    public Game(int N, int S) {
        area = new boolean[N][N];
        this.N = N;
        this.seed = S;
        fill();
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public void fill(int seed) {
        this.seed = seed;
        fill();
    }

    public void fill() {
        Random random = new Random(seed);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ret.append(area[i][j] ? "O" : " ");
            } ret.append("\n");
        }

        return ret.toString();
    }
}
