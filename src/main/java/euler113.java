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
    public static long digitsLowerThreshold = (long) Math.pow(10, numDigits - 1);
    public static long digitsUpperThreshold = (long) Math.pow(10, numDigits);
    public static long countNotBouncy = 0;
    public static long countBouncy = 0;
    public static ArrayList<String> increasingWithNDigits = new ArrayList<String>();
    public static ArrayList<String> decreasingWithNDigits = new ArrayList<String>();
    // both increasing and decreasing, e.g. 777
    public static ArrayList<String> bothWithNDigits = new ArrayList<String>();
    int[] intDigits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] strDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean isIncreasing(Apint n) {
        if (n.compareTo(TEN) == -1) {
            return true;
        }
        char[] charsN = n.toString().toCharArray();
        int len = charsN.length;
        for (int i = 0; i < len - 1; i++) {
            int d1 = Character.getNumericValue(charsN[i]);
            int d2 = Character.getNumericValue(charsN[i + 1]);
            if (d2 < d1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(Apint n) {
        if (n.compareTo(TEN) == -1) {
            return true;
        }
        char[] charsN = n.toString().toCharArray();
        int len = charsN.length;
        for (int i = 0; i < len - 1; i++) {
            int d1 = Character.getNumericValue(charsN[i]);
            int d2 = Character.getNumericValue(charsN[i + 1]);
            if (d2 > d1) {
                return false;
            }
        }
        return true;
    }

    public static void calculateInitialValues() {
        Apint ap;
        for (long n = 1; n < digitsUpperThreshold; n++) {
            ap = new Apint(n);
            boolean isInc = isIncreasing(ap);
            boolean isDec = isDecreasing(ap);
            if (isInc || isDec) {
                countNotBouncy += 1;
                if (n >= digitsLowerThreshold) {
                    if (isInc && isDec) {
                        bothWithNDigits.add(ap.toString());
                    } else if (isInc) {
                        increasingWithNDigits.add(ap.toString());
                    } else {
                        decreasingWithNDigits.add(ap.toString());
                    }
                }
            } else {
                countBouncy += 1;
            }
        }
        System.out.println("n < " + digitsUpperThreshold + " (10^" + numDigits + ") num not bouncy: " +
                countNotBouncy);
    }

    public static void calculateNextValues() {
        ArrayList<String> increasingWithNPlusOneDigits = new ArrayList<String>();
        ArrayList<String> decreasingWithNPlusOneDigits = new ArrayList<String>();
        ArrayList<String> bothWithNPlusOneDigits = new ArrayList<String>();
        String strN;
        int leftDigitInt;
        int rightDigitInt;
        String newNum;
        for (int i = 0; i < increasingWithNDigits.size(); i++) {
            strN = increasingWithNDigits.get(i);
            leftDigitInt = Character.getNumericValue(strN.charAt(0));
            rightDigitInt = Character.getNumericValue(strN.charAt(strN.length() - 1));
            // can't add a zero to the left
            for (int j = 1; j <= leftDigitInt; j++) {
                newNum = Character.forDigit(j, 10) + strN;
                if (!increasingWithNPlusOneDigits.contains(newNum)) {
                    increasingWithNPlusOneDigits.add(newNum);
                } else {
                    System.out.println("Dup " + newNum);
                }
            }
            for (int j = rightDigitInt; j < 10; j++) {
                newNum = strN + Character.forDigit(j, 10);
                if (!increasingWithNPlusOneDigits.contains(newNum)) {
                    increasingWithNPlusOneDigits.add(newNum);
                }
                else {
                    System.out.println("Dup " + newNum);
                }
            }
        }
        for (int i = 0; i < decreasingWithNDigits.size(); i++) {
            strN = decreasingWithNDigits.get(i);
            leftDigitInt = Character.getNumericValue(strN.charAt(0));
            rightDigitInt = Character.getNumericValue(strN.charAt(strN.length() - 1));
            for (int j = leftDigitInt; j < 10; j++) {
                newNum = Character.forDigit(j, 10) + strN;
                if (!decreasingWithNPlusOneDigits.contains(newNum)) {
                    decreasingWithNPlusOneDigits.add(newNum);
                }
            }
            for (int j = 0; j <= rightDigitInt; j++) {
                newNum = strN + Character.forDigit(j, 10);
                if (!decreasingWithNPlusOneDigits.contains(newNum)) {
                    decreasingWithNPlusOneDigits.add(newNum);
                }
            }
        }
        for (int i = 0; i < bothWithNDigits.size(); i++) {
            strN = bothWithNDigits.get(i);
            newNum = strN + strN.substring(0, 1);
            if (!bothWithNPlusOneDigits.contains(newNum)) {
                bothWithNPlusOneDigits.add(newNum);
            }
        }
        decreasingWithNDigits = decreasingWithNPlusOneDigits;
        increasingWithNDigits = increasingWithNPlusOneDigits;
        bothWithNDigits = bothWithNPlusOneDigits;
        long countAll = decreasingWithNDigits.size() + increasingWithNDigits.size() + bothWithNDigits.size();
        countNotBouncy += countAll;
    }

    public static void calculateEuler113() {
        calculateInitialValues();
        for (int nd = numDigits + 1; nd <= endNumDigits; nd++) {
            calculateNextValues();
            System.out.println("n < " + (long) Math.pow(10, nd) + " (10^" + nd + ") num not bouncy: " +
                    countNotBouncy);
        }
    }


}
