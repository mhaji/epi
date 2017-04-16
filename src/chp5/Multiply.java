package chp5;

/**
 * Created by mhaji on 19/03/2017.
 */
public class Multiply {

    /**
     * Returns the product of a and b without using arithmetical operators
     */
    public static long multiply(long a, long b) {
        long result = 0;

        while(a != 0) {
            if ((a & 1) != 0) {
                result = sum(result, b);
            }

            a >>>= 1;
            b <<= 1;
        }
        return result;
    }

    private static long sum(long x, long y) {
        long k = 1, sum = 0, carryin = 0, tmpx = x,  tmpy = y;
        while(tmpx != 0 || tmpy != 0) {
            long xk = x & k, yk = y & k;
            sum |= (xk ^ yk ^ carryin);
            long carryout = (xk & yk) | (xk & carryin) | (yk & carryin);
            k <<= 1;
            carryin = carryout << 1;
            tmpx >>>= 1;
            tmpy >>>= 1;
        }
        return sum | carryin;
    }

    public static void main(String[] args) {
        System.out.println(Multiply.multiply(15, 21) == (15 * 21));
    }

}
