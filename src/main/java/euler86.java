public class euler86 {

    static double epsilon = 0.000001;

    public static boolean isPerfectSquare(long i) {
        double sqrti = Math.sqrt(i);
        double e = Math.abs(sqrti - Math.rint(sqrti));
        if (e < epsilon) {
            return true;
        }
        return false;
    }


    public static void calculate_euler86() {
        int M = 93;
        int count = 1751;
        long p1, p2, p3, minp;
        System.out.println("Total count is " + count + " for M=" + M);
        int prev_count, z;
        while (count < 1000000) {
            prev_count = count;
            M = M + 1;
            z = M;
            for (int x = 1; x <= M; x = x + 1) {
                for (int y = x; y <= M; y = y + 1) {
                    p1 = x * x + (y + z) * (y + z);
                    p2 = y * y + (x + z) * (x + z);
                    p3 = z * z + (x + y) * (x + y);
                    minp = Math.min(Math.min(p1, p2), p3);
                    if (isPerfectSquare(minp)) {
                        count = count + 1;
                    }
                }
            }
            System.out.println("Total count is " + count + " for M=" + M);
        }
    }

}
