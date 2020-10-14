package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int N = scanner.nextInt();
        final Long S = scanner.nextLong();
        final int genLen = scanner.nextInt();

        scanner.close();

        Universe universe = new Universe(N, S);
        Generation generation = new Generation(universe);

        for (int i = 0; i < genLen; i++) {
            generation.nextGen();
        }

        System.out.println(universe.toString());
    }
}
