package life;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();

        final int N = scanner.nextInt();  // size (of width and height)
        final Long S = random.nextLong(); // seed

        scanner.close();

        Universe universe = new Universe(N, S);
        Generation generation = new Generation(universe);

        for (int i = 0; i < 10; i++) {
            System.out.println(universe.toString());
            generation.nextGen();
            clearConsole();
        }
    }

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }
}
