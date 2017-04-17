package chp5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mhaji on 16/04/2017.
 */
public class UniformRandomNum {
    /**
     * Generates a random number within the range of lowerBound to upperBound (inclusive).
     */
    public static int rand(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1, result;
        final int r = (int) Math.ceil(Math.log(numberOfOutcomes) / Math.log(2));
        do {
            result = 0;
            for(int i = 0; i < r; i++) {
                result = (result << 1) | zeroOrOneRandom();
            }
        } while(result >= numberOfOutcomes);
        return result + lowerBound;
    }

    private static int zeroOrOneRandom() {
        return new Random().nextInt(2);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        final double iterations = 100000.0;
        for(int i = 0; i < iterations; i++) {
            int rand = rand(1, 6);
            map.put(rand, map.getOrDefault(rand, 0) + 1);
        }

        map.forEach((k, v) -> {
            System.out.println("k: " + k + ", v: " + v + ", p: " + 100 * (double) v / iterations + "%");
        });
    }
}
