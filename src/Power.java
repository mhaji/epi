/**
 * Created by mhaji on 15/04/2017.
 */
public class Power {

    /**
     * Return x to the power of y. Doesn't handle overflows
     */
    public static double powRecursive(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            n = -n; // can result in overflow if n = Integer.MIN_VALUE;
            x = 1.0/x;
        }

        double tmp = powRecursive(x, n/2);

        if(n % 2 == 0) {
            return tmp * tmp;
        } else {
            return x * tmp * tmp;
        }
    }


    public static double powIterative(double x, int n) {
        if(n == 0) {
            return 1;
        }
        long power = n;
        if(n < 0) {
            power = -power;
            x = 1.0 / x;
        }
        double result = 1.0;
        while(power != 0) {
            if(power % 2 != 0) {
                result *= x;
            }

            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(powRecursive(5, 5) == Math.pow(5, 5));
        System.out.println(powRecursive(5, -1) == Math.pow(5, -1));

        System.out.println(powIterative(5, 17) == Math.pow(5, 17));
        System.out.println(powIterative(5, -1) == Math.pow(5, -1));
    }
}
