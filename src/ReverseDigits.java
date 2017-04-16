/**
 * Created by mhaji on 16/04/2017.
 */
public class ReverseDigits {


    public static int reverse(int n) {
        int reverse = 0;
        int abs_n = Math.abs(n);
        while(abs_n != 0) {
            reverse = reverse * 10 + abs_n % 10;
            abs_n /= 10;
        }

        return n < 0 ? -reverse : reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-98761) == -16789);
    }
}
