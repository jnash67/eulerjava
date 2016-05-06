import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by jnash on 3/23/2016.
 */
public class euler543 {

    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return a;
    }

    public static int countPrimes(int mLimit, BitSet primeList) {
        int count = 1;
        for (int num = 3; num <= mLimit; num += 2) {
            if (primeList.get(num)) {
                count = count + 1;
            }
        }
        return count;
    }

    // adapted from: http://stackoverflow.com/questions/3094722/improving-a-prime-sieve-algorithm
    static private BitSet sieve(int n) {
        BitSet primeList = new BitSet(n);
        primeList.set(0, n - 1, true);

        int sqroot = (int) Math.sqrt(n);
        primeList.clear(0);
        for (int num = 3; num <= sqroot; num += 2) {
            if (primeList.get(num)) {
                int inc = num;
                for (int factor = num * num; factor < n; factor += inc) {
                    primeList.clear(factor);
                }
            }
        }
        return primeList;
    }

    static private BitSet allOddSumsOfTwoPrimes(int mLimit, BitSet primeList) {
        BitSet sumsList = new BitSet(mLimit + 1);
        sumsList.set(0, mLimit, false);
        int p1 = 2;
        int p1p2 = 0;
        for (int p2 = 3; p2 <= mLimit; p2 += 2) {
            if (primeList.get(p2)) {
                p1p2 = p1 + p2;
                sumsList.set(p1p2);
            }
        }
        return sumsList;
    }

    static long S(int n, BitSet primeList, BitSet oddSumOfTwoPrimesList) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        long ssum = 0;
        // we add one for prime 2 and one for prime 3
        ssum = ssum + 2;
        // by Goldbach Conjecture and because any even number k can be made of any number of primes > 2 up to all 2s
        for (int i = 4; i < n + 1; i = i + 2) {
            int addend = (int) (i / 2) - 1;
            ssum = ssum + addend;
        }
        // by Waring's Prime Number Conjecture and because any odd number k can be made of any number of
        // primes > 2 up to all 2s minus 1. Main question is whether it is prime and whether there
        // are two primes that make up the odd number
        for (int i = 5; i < n + 1; i = i + 2) {
            int addend = (int) (i / 2) - 2;
            ssum = ssum + addend;
            if (primeList.get(i)) {
                ssum = ssum + 1;
            }
            if (oddSumOfTwoPrimesList.get(i)) {
                ssum = ssum + 1;
            }
        }
        return ssum;
    }

    static void calc_euler_543() {
        ArrayList<Integer> fibList = new ArrayList<Integer>();
        for (int i = 3; i <= 44; i++) {
            fibList.add(fibonacci(i));
        }
        int f44 = fibList.get(41);
        BitSet primeList = sieve(f44);
        BitSet sumsList = allOddSumsOfTwoPrimes(f44, primeList);

        long s10 = S(10, primeList, sumsList);
        long s100 = S(100, primeList, sumsList);
        long s1000 = S(1000, primeList, sumsList);
        System.out.println("S(10)=" + s10);
        System.out.println("S(100)=" + s100);
        System.out.println("S(1000)=" + s1000);

        long totalSum = 0;
        long ssum = 0;
        int f = 3;
        for (Integer fib : fibList) {
            ssum = S(fib, primeList, sumsList);
            System.out.println("S(F(" + f + ")) is " + ssum + " where F(" + f + ") is " + fib);
            totalSum = totalSum + ssum;
            f = f + 1;
        }
        System.out.println("Sum over the fibonaccis is " + totalSum);
    }
}
