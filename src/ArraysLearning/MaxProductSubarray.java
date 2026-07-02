package ArraysLearning;

public class MaxProductSubarray {
    public static void main(String[] args) {

    }

    public static long getMaxProductByOptimal(int[] numbs) {
        long maxProd = Integer.MAX_VALUE;
        int n = numbs.length;
        long prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= numbs[i];
            suffix *= numbs[n - 1 - i];
            maxProd = Math.max(maxProd, Math.max(suffix, prefix));
        }

        return maxProd;
    }

    public static long getMaxProduct(int[] numbs) {
        long maxProd = 1;

        for (int i = 0; i < numbs.length; i++) {
            long currProd = 1;
            for (int j = i+1; j < numbs.length; j++) {
                currProd *= numbs[j];
                maxProd = Math.max(maxProd, currProd);
            }
        }
        return maxProd;
    }
}
