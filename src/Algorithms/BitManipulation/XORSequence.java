package Algorithms.BitManipulation;
import java.util.Scanner;

public class XORSequence {

    private static long getXor(long x) {

        long a = x % 8;

        if (a == 0 || a == 1) {
            return x;
        }
        if (a == 2 || a == 3) {
            return 2;
        }
        if (a == 4 || a == 5) {
            return x + 2;
        }
        if (a == 6 || a == 7) {
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int c = scanner.nextInt(); c > 0; c--) {
            long L = scanner.nextLong(), R = scanner.nextLong();
            System.out.println(getXor(R) ^ getXor(L - 1));
        }
        scanner.close();
    }
}

