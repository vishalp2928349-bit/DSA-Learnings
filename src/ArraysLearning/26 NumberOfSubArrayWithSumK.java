package ArraysLearning;

import java.util.HashMap;

 class NumberOfSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-3,1,1,1,4,2,-3};
        int count = noOfSubArrayWithK(nums,3);
        System.out.println(count);
        int newCnt = countByOptimal(nums, 3);
        System.out.println(newCnt);
    }

    public static int countByOptimal(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static int noOfSubArrayWithK(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
