package chp5;

/**
 * Created by mhaji on 13/03/2017.
 */
public class SwapBits {

    /**
     * Swaps bits i and j in x.
     * Checks if bits at i and j differ, then does swap.
     */
    public static long swapBits(long x, int i, int j) {
        if(((x >>> i) & 1) != ((x >>> j) & 1)) {
            long mask = (1L << i) | (1L << j);
            x ^= mask;
        }
        return x;
    }


    public static void main(String[] args) {
        System.out.println(swapBits(1234L, 2, 6) == 1174);
    }
}
