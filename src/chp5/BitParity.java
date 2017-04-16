package chp5;

/**
 * Created by mhaji on 13/03/2017.
 */
public class BitParity {

    /**
     * The parity of x is 1 if the number of bits set in x
     * is odd, otherwise the parity is 0.
     *
     * make use of xor, parity will toggle every time a 1 is encountered.
     * Brute force soln - O(n) where n is word length
     */
    public static short parity(long x) {
        short parity = 0;
        while(x > 0) {
            parity ^= (x&1);
            x >>>= 1;
        }
        return parity;
    }

    /**
     * Improves on parity() by in best and average cases by iterating
     * only when required. Still O(n) in worst case, in average case is
     * O(k) where k is number of set bits.
     */
    public static short parity2(long x) {
        short parity = 0;
        while(x > 0) {
            parity ^= 1;
            x &= (x - 1); // drop lowest sit bit
        }
        return parity;
    }

    // To be populated with the parity of all 16-bit words
    // This required an array 1 << 16 (65536) elements which
    // fits easily into memory.
    private static final short[] preComputedParity = new short[1 << 16];

    private static final int WORD_SIZE = 16;
    private static final int BIT_MASK = 0xFFFF;

    /**
     * parity operation is associative, therefore we can
     * pre-compute the parity for all 16-bit sub-words and
     * then xor their results.
     */
    public static short parityCached(long x) {
        return (short) (  preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
                        ^ preComputedParity[(int) ((x >>> (2 * WORD_SIZE)) & BIT_MASK)]
                        ^ preComputedParity[(int) ((x >>> WORD_SIZE) & BIT_MASK)]
                        ^ preComputedParity[(int) (x & BIT_MASK)]);
    }

    public static void main(String[] args) {
        System.out.println(parity2(7) == 1);
        System.out.println(parity2(6) == 0);
        System.out.println(parity2(2) == 1);
        System.out.println(parity2(1) == 1);
        System.out.println(parity2(3) == 0);
    }

}
