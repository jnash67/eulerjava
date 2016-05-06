import java.util.BitSet;

/**
 * Created by jnash on 3/22/2016.
 */
public class SpaceSavingPrimes {

    public static boolean isPrime(int num, int maxLimit, BitSet spaceSavingPrimeList) {
        if (num <= maxLimit) {
            if ((num & 1) == 0)
                return (num == 2);
            else
                return spaceSavingPrimeList.get(num >> 1);
        }
        return false;
    }

    public static int countPrimes(int mLimit, BitSet spaceSavingPrimeList) {
        int count = 1;
        for (int num = 3; num <= mLimit; num += 2) {
            if (isPrime(num, mLimit, spaceSavingPrimeList)) {
                count = count + 1;
            }
        }
        return count;
    }

    // from: http://stackoverflow.com/questions/3094722/improving-a-prime-sieve-algorithm
    static private BitSet sieve(int n) {
        // mLimit >> 1 is like integer dividing by 2
        BitSet spaceSavingPrimeList = new BitSet(n >> 1);
        spaceSavingPrimeList.set(0, spaceSavingPrimeList.size() - 1, true);

        int sqroot = (int) Math.sqrt(n);
        spaceSavingPrimeList.clear(0);
        for (int num = 3; num <= sqroot; num += 2) {
            if (spaceSavingPrimeList.get(num >> 1)) {
                int inc = num << 1;
                for (int factor = num * num; factor < n; factor += inc) {
                    spaceSavingPrimeList.clear(factor >> 1);
                }
            }
        }
        return spaceSavingPrimeList;
    }

}
