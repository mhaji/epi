package chp5;

/**
 * Created by mhaji on 19/03/2017.
 */
public class ClosestNumSameWeight {
    /**
     * returns the closest long to x, that has the same weight (no. of bits)
     * algorithm: swap two rightmost bits that differ
     */
    public static long closestNumSameWeight(long x) {

        final int WORD_LEN = 64;

        for(int i = 0; i < WORD_LEN - 1; i++) {
            if(((x >>> i) & 1) != ((x >>> (i+1)) & 1)) {
                long mask = (1L << i) | (1L << (i+1));
                x ^= mask;
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0s or 1s");
    }

    public static void main(String[] args) {
        System.out.println(closestNumSameWeight(6) == 5);
    }
}

