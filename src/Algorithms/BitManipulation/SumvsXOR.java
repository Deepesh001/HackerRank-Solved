package Algorithms.BitManipulation;

import java.util .*;

public class SumvsXOR {

    public static long countValues(long n) {

        long unset_bits = 0;
        while (n > 0) {
            if ((n & 1) == 0)
                unset_bits++;
            n = n >> 1;
        }

        return 1L << unset_bits;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();

        System.out.println(countValues(n));

    }
}
