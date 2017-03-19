/**
 * Created by mhaji on 19/03/2017.
 */
public class ReverseBits {

    /**
     * reverses the bits that represent x
     * brute-force, O(n) where n is the word length
     */
    public static long reverseBits(long x, int wordLen) {
        for(int i = 0, j = wordLen; i < j; i++, j--) {
            x = SwapBits.swapBits(x, i, j);
        }
        return x;
    }

}
