import java.util.HashMap;
import java.util.Map;

public class euler110 {

    // If n = (p1^a1)(p2^a2)...(pt^at),
    // a(n) = ((2 a1 + 1)(2 a2 + 1) ... (2 at + 1) + 1) / 2.
    private static long a(long n) {
        Map<Long, Long> primes = primeDivisors(n);
        int x = 1;
        for(long ai: primes.values()) {
            x *= (2*ai)+1;
        }
        return (x+1)/2;
    }

    private static Map<Long, Long> primeDivisors(long n) {
        Map<Long, Long> primes = new HashMap<Long, Long>();
        long d = 2;
        while(n > 1) {
            if(n%d == 0) {
                Long frequence = primes.remove(d);
                if(frequence == null) {
                    frequence = 0L;
                }
                frequence++;
                primes.put(d, frequence);
                n /= d;
            } else {
                d++;
            }
        }
        return primes;
    }

    public static void calculate_euler110() {
        long n = 4000000^2, max = 0;
        for(long i = 1; i < n; i++) {
            long temp = a(i);
            if(temp > max) {
                max = temp;
                System.out.println("n="+i+" -> max="+max);
            }
            if(max > 4000000) break;
        }
    }

}
