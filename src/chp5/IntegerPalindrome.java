package chp5;

/**
 * Created by mhaji on 16/04/2017.
 */
public class IntegerPalindrome {

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        final int numDigits = (int) Math.floor(Math.log10(x)) + 1;
        int msdDivisor = (int) Math.pow(10, numDigits - 1);

        for(int i = 0; i < numDigits / 2; i++) {
            if(x % 10 != x / msdDivisor) {
                return false;
            }
            x %= msdDivisor; // drop msd
            x /= 10;// drop lsd
            msdDivisor /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(11));

        System.out.println(isPalindrome(42));
        System.out.println(isPalindrome(12332));
        System.out.println(isPalindrome(-1234321));
    }

}
