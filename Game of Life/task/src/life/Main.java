package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final int S = scanner.nextInt();

        scanner.close();

        Game game = new Game(N, S);
        System.out.println(game.toString());
    }
}
