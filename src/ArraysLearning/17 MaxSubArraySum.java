package ArraysLearning;

 class MaxSubArraySum {
    public static void main(String[] args) {

    }

    //if we want to give max subarray
    public static int[] maxSubArray(int[] nums) {
        int ansStart = -1, ansEnd = -1;
        int start = -1;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) start = i;
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[] {ansStart, ansEnd};
    }

    public static int maxSubArrayByKadane(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if (sum < 0 ) {
                sum = 0;
            }
        }
        return maxi;
    }

    public static int maxSubArrayByBetter(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    public static int maxSubArraySum(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                    maxi = Math.max(maxi, sum);
                }
            }
        }
        return maxi;
    }
}
