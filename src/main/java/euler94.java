import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;

/**
 * Created by jnash on 3/23/2016.
 */
public class euler94 {

    static int PRECISION = 10;
    static Apfloat epsilon = new Apfloat(0.000001);

    static Apint ZERO = new Apint(0);
    static Apint TEN = new Apint(10);
    static Apint HUNDRED = new Apint(100);
    static Apint TWO = new Apint(2);
    static Apint THREE = new Apint(3);
    static Apint FOUR = new Apint(4);

    public static double heron(long a, long b, long c) {
        double s = (a + b + c) / 2;
        double h = s * (s - a) * (s - b) * (s - c);
        double area = Math.sqrt(h);
        return area;
    }

    public static Apfloat triangle_area_squared(long a, long b, long c) {
        Apfloat apa, apb, apc, aps, aph;
        Apfloat apsminusa, apsminusb, apsminusc;
        apa = new Apfloat(a, PRECISION);
        apb = new Apfloat(b, PRECISION);
        apc = new Apfloat(c, PRECISION);

        aps = apa.add(apb).add(apc).divide(TWO);

        apsminusa = aps.subtract(apa);
        apsminusb = aps.subtract(apb);
        apsminusc = aps.subtract(apc);
        aph = aps.multiply(apsminusa).multiply(apsminusb).multiply(apsminusc);
        return aph;
    }

    public static boolean isPerfectSquare(Apfloat ap) {
        Apfloat sqrt = ApfloatMath.sqrt(ap);
        Apfloat ceil = ApfloatMath.ceil(sqrt);
        if (ceil.multiply(ceil).equals(ap)) {
            return true;
        }
        Apfloat floor = ApfloatMath.floor(sqrt);
        if (floor.multiply(floor).compareTo(ap)==0) {
            System.out.println("ap -> " + ap.toString(true) + "sqrt -> " + sqrt.toString(true) +
                    " ceil -> " + ceil.toString(true) +
                    " floor -> " + floor.toString(true));
        }
        return false;
    }


    public static boolean isInteger(double d) {
        if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
            return true;
        }
        return false;
    }

//    public static boolean isInteger_apfloat(Apfloat ap) {
//        if (ApfloatMath.abs(ApfloatMath.ceil(ap).subtract(ap)).compareTo(epsilon) <= 0) {
//            return true;
//        }
//        if (ApfloatMath.abs(ApfloatMath.floor(ap).subtract(ap)).compareTo(epsilon) <= 0) {
//            System.out.println("For " + ap.toString(true) + " the floor worked");
//        }
//        return false;
//    }


    public static void calculate_euler94() {

        long billion = (long) Math.pow(10, 9);
        double epsilon = 0.000001;
        Apint sumOfPerimetersLessThanOrEqual = ZERO;
        Apint sumOfPerimetersLessThan = ZERO;
        int count = 0;
        for (long a = 5; a <= billion; a++) {
            if (a % 1000000 == 0) {
                System.out.println("Checked a million " + a + " count is " + count);
            }
            long per1 = a + a + a + 1;
            long per2 = a + a + a - 1;

            Apfloat areasq1 = triangle_area_squared(a, a, a + 1);
            Apfloat areasq2 = triangle_area_squared(a, a, a - 1);

            if (per1 <= billion) {
                if (isPerfectSquare(areasq1)) {
                    count++;
                    System.out.println("Triangle " + a + " " + a + " " + (a+1) +" with perim " + per1 + " qualifies");
                    sumOfPerimetersLessThanOrEqual = sumOfPerimetersLessThanOrEqual.add(new Apint(per1));
                    if (per1 != billion) {
                        sumOfPerimetersLessThan = sumOfPerimetersLessThan.add(new Apint(per1));
                    }
                }
            }

            if (per2 <= billion) {
                if (isPerfectSquare(areasq2)) {
                    count++;
                    System.out.println("Triangle " + a + " " + a + " " + (a-1) +" with perim " + per2 + " qualifies");
                    sumOfPerimetersLessThanOrEqual = sumOfPerimetersLessThanOrEqual.add(new Apint(per2));
                    if (per2 != billion) {
                        sumOfPerimetersLessThan = sumOfPerimetersLessThan.add(new Apint(per2));
                    }
                }
            }

            if ((per1 > billion) && (per2 > billion)) {
                break;
            }

        }
        System.out.println("Sum of perims less than or equal is " + sumOfPerimetersLessThanOrEqual.toString(true));
        System.out.println("Sum of perims less than is " + sumOfPerimetersLessThan.toString(true));
    }
}
