import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by jnash on 3/23/2016.
 */
public class euler94pt2 {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigDecimal triangle_area_squared(long a, long b, long c) {
        BigDecimal bia, bib, bic, bis, bih;
        BigDecimal bisminusa, bisminusb, bisminusc;
        bia = BigDecimal.valueOf(a);
        bib = BigDecimal.valueOf(b);
        bic = BigDecimal.valueOf(c);

        bis = bia.add(bib).add(bic).divide(BigDecimal.valueOf(2));

        bisminusa = bis.subtract(bia);
        bisminusb = bis.subtract(bib);
        bisminusc = bis.subtract(bic);
        bih = bis.multiply(bisminusa).multiply(bisminusb).multiply(bisminusc);
        return bih;
    }

    public static boolean isPerfectSquare(BigDecimal bd) {
        BigInteger bi = bd.toBigInteger();
        BigInteger isqrt = BigIntegerUtils.integer_sqrt(bi);
        if (isqrt.multiply(isqrt).equals(bi)) {
            return true;
        } else {
            return false;
        }
    }

    public static void calculate_euler94pt2() {

        long billion = (long) Math.pow(10, 9);
        double epsilon = 0.000001;
        BigInteger sumOfPerimetersLessThanOrEqual = BigInteger.ZERO;
        BigInteger sumOfPerimetersLessThan = BigInteger.ZERO;
        int count = 0;
        for (long a = 5; a <= billion; a++) {
            if (a % 1000000 == 0) {
                System.out.println("Checked a million " + a + " count is " + count);
            }
            long per1 = a + a + a + 1;
            long per2 = a + a + a - 1;

            BigDecimal areasq1 = triangle_area_squared(a, a, a + 1);
            BigDecimal areasq2 = triangle_area_squared(a, a, a - 1);

            if (per1 <= billion) {
                if (isPerfectSquare(areasq1)) {
                    count++;
                    System.out.println("Triangle " + a + " " + a + " " + (a+1) +" with perim " + per1 + " qualifies");
                    sumOfPerimetersLessThanOrEqual = sumOfPerimetersLessThanOrEqual.add(BigInteger.valueOf(per1));
                    if (per1 != billion) {
                        sumOfPerimetersLessThan = sumOfPerimetersLessThan.add(BigInteger.valueOf(per1));
                    }
                }
            }

            if (per2 <= billion) {
                if (isPerfectSquare(areasq2)) {
                    count++;
                    System.out.println("Triangle " + a + " " + a + " " + (a-1) +" with perim " + per2 + " qualifies");
                    sumOfPerimetersLessThanOrEqual = sumOfPerimetersLessThanOrEqual.add(BigInteger.valueOf(per2));
                    if (per2 != billion) {
                        sumOfPerimetersLessThan = sumOfPerimetersLessThan.add(BigInteger.valueOf(per2));
                    }
                }
            }

            if ((per1 > billion) && (per2 > billion)) {
                break;
            }

        }
        System.out.println("Sum of perims less than or equal is " + sumOfPerimetersLessThanOrEqual.toString());
        System.out.println("Sum of perims less than is " + sumOfPerimetersLessThan.toString());
    }
}
