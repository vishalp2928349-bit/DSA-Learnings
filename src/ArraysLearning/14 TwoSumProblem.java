package ArraysLearning;

import java.util.Arrays;
import java.util.HashMap;

class TwoSumProblem {
    public static void main(String[] args) {
        int[] nums = {2,6,5,8,11};
        int[] newArr = twoSumByBrute(nums, 14);
        for (int num : newArr) {
            System.out.print(num + " ");
        }
        System.out.println();

        newArr = twoSumByBetter(nums, 14);
        for (int num : newArr) {
            System.out.print( num + " ");
        }
        System.out.println();

        boolean isPresent = twoSumByOptimal(nums, 15);

        if (isPresent) System.out.println("Yes");
        else System.out.println("No");

    }

    public static boolean twoSumByOptimal(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }

        }
        return false;
    }

    public static int[] twoSumByBetter(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int remSum ;

        for (int i = 0; i < nums.length; i++) {
            remSum = k - nums[i];
            if (map.containsKey(remSum)) {
                return new int[] {i, map.get(remSum)};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static int[] twoSumByBrute(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == k) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }
}
