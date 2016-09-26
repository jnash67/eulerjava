import org.apfloat.Apint;
import org.apfloat.ApintMath;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by jnash on 9/12/2016.
 */
public class euler113 {

    static Apint ONE = new Apint(1);
    static Apint TEN = new Apint(10);

    public static int numDigits = 3;
    public static int endNumDigits = 10;
    public static long digitsLowerThreshold = 10 ^ (numDigits - 1);
    public static long digitsUpperThreshold = 10 ^ numDigits;
    public static long countNotBouncy = 0;
    public static long countBouncy = 0;
    public static TreeSet<Long> increasingWithNDigits = new TreeSet<Long>();
    public static TreeSet<Long> decreasingWithNDigits = new TreeSet<Long>();
    // both increasing and decreasing, e.g. 777
    public static TreeSet<Long> bothWithNDigits = new TreeSet<Long>();
    public static TreeSet<Apint> increasingWithNPlusOneDigits = new TreeSet<Apint>();
    public static TreeSet<Apint> decreasingWithNPlusOneDigits = new TreeSet<Apint>();
    public static TreeSet<Apint> bothWithNPlusOneDigits = new TreeSet<Apint>();
    int[] intDigits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] strDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean isIncreasing(String strN) {
        int len = strN.length();
        char[] charsN = strN.toCharArray();
        for (int i = 0; i < len; i++) {
            int d1 = Character.getNumericValue(charsN[i]);
            int d2 = Character.getNumericValue(charsN[i + 1]);
            if (d2 < d1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(String strN) {
        int len = strN.length();
        char[] charsN = strN.toCharArray();
        for (int i = 0; i < len; i++) {
            int d1 = Character.getNumericValue(charsN[i]);
            int d2 = Character.getNumericValue(charsN[i + 1]);
            if (d2 > d1) {
                return false;
            }
        }
        return true;
    }

    public static void calculateInitialValues() {
        for (long n = 1; n < digitsUpperThreshold; n++) {
            String strN = Long.toString(n);
            int len = strN.length();
            boolean isInc = isIncreasing(strN);
            boolean isDec = isDecreasing(strN);
            if (isInc || isDec) {
                countNotBouncy += 1;
                if (n >= digitsLowerThreshold) {
                    if (isInc && isDec) {
                        bothWithNDigits.add(n);
                    } else if (isInc) {
                        increasingWithNDigits.add(n);
                    } else {
                        decreasingWithNDigits.add(n);
                    }
                }
            } else {
                countBouncy += 1;
            }
        }
        System.out.println("n < " + digitsUpperThreshold + " (10^" + digitsUpperThreshold + " num not bouncy: " + countNotBouncy);
    }

    public static void calculateEuler113() {
        int[] primes = new int[10];
        Math.makePrimes(primes);
        recursion(primes, 0, 1, 1);

    }

    public static void recursion(int[] primes, int pos, long num, int amount) {
        if (num <= 0 || num > numMin) return;
        int primeAmount = 1;
        while (amount * (primeAmount + 1) <= target) {
            primeAmount++;
            recursion(primes, pos + 1, num * use.pow(primes[pos], primeAmount), amount * (primeAmount + 1));
        }
        long x = use.pow(primes[pos], primeAmount) * num;
        if (x < numMin && x > 0 && use.isSqrt(x)) numMin = x;
    }
}
