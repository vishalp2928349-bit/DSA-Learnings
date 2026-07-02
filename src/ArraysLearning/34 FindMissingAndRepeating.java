package ArraysLearning;

 class FindMissingAndRepeating {
    public static void main(String[] args) {

    }

    public static int[] getByOptimalMath(int[] numbs) {
        // s - sn = x-y
        //s2 = s2n
        long n = numbs.length;
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2*n+1)) / 6;
        long S = 0, S2 = 0;

        for (int i = 0; i < n; i++) {
            S += numbs[i];
            S2 += (long) numbs[i] * (long) numbs[i];
        }

        long val1 = S - SN; // x-y
        long val2 = S2 - S2N;
        val2 = val2 / val1; // x+y

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[] {(int) x, (int) y};
    }

    public static int[] getByBetter(int[] numbs) {
        int n = numbs.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[numbs[i]]++;
        }

        int repeat = -1, missing = -1;
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) repeat = i;
            else if (hash[i] == 0)  missing = i;
            if (missing != -1 && repeat != -1) break;
        }
        return new int[] {repeat, missing};
    }

    public static int[] getMissingRepeating(int[] numbs) {
        int repeat = -1, missing = -1;
        for (int i = 1; i <= numbs.length; i++) {
            int cnt = 0;
            for (int j = 0; j < numbs.length; j++) {
                if (numbs[j] == i) cnt++;
            }
            if (cnt == 2) repeat = i;
            else if (cnt == 0) missing = i;
            if (repeat != -1 && missing != -1) break;
        }
        return new int[] {repeat,missing};
    }
}
