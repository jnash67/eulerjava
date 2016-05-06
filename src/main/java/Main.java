import org.apfloat.Apfloat;

import java.math.BigDecimal;

public class Main {

    public static void euler94() {
        Apfloat t;

        System.out.println("Triangle 5, 5, 6");
        t = euler94.triangle_area_squared(5,5,6);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 8, 8, 9");
        t = euler94.triangle_area_squared(8,8,9);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 12545, 12545, 12546");
        t = euler94.triangle_area_squared(12545,12545,12546);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 333333331, 333333331, 333333332");
        t = euler94.triangle_area_squared(333333331, 333333331, 333333332);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 92694733, 92694733, 92694734");
        t = euler94.triangle_area_squared(92694733,92694733,92694734);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 235000835, 235000835, 235000836");
        t = euler94.triangle_area_squared(235000835,235000835,235000836);
        System.out.println(t.toString(true));
        System.out.println(euler94.isPerfectSquare(t));
        System.out.println();

        //euler543.calc_euler_543();
        euler94.calculate_euler94();
    }

    public static void euler94pt2() {
        BigDecimal t;

        System.out.println("Triangle 5, 5, 6");
        t = euler94pt2.triangle_area_squared(5,5,6);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 8, 8, 9");
        t = euler94pt2.triangle_area_squared(8,8,9);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 12545, 12545, 12546");
        t = euler94pt2.triangle_area_squared(12545,12545,12546);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 333333331, 333333331, 333333332");
        t = euler94pt2.triangle_area_squared(333333331, 333333331, 333333332);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 92694733, 92694733, 92694734");
        t = euler94pt2.triangle_area_squared(92694733,92694733,92694734);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        System.out.println("Triangle 235000835, 235000835, 235000836");
        t = euler94pt2.triangle_area_squared(235000835,235000835,235000836);
        System.out.println(t);
        System.out.println(euler94pt2.isPerfectSquare(t));
        System.out.println();

        //euler543.calc_euler_543();
        euler94pt2.calculate_euler94pt2();
    }


    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        euler86.calculate_euler86();

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
