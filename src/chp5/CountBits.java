package chp5;

/**
 * Created by mhaji on 13/03/2017.
 */
public class CountBits {

    /**
     * returns the number of bits set to 1 in x
     *
     * complexity is O(n) where n is number of bits in x
     */
    public static short bits(int x) {
        short count = 0;
        while(x > 0) {
            count += (x&1);
            x >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bits(128) == 1);
        System.out.println(bits(127) == 7);
        System.out.println(bits(3) == 2);
    }
}
