package ArraysLearning;

import java.util.Arrays;
import java.util.HashSet;

 class LongestConsecutive {
    public static void main(String[] args) {
        int[] arr = {100,101,1, 1, 1, 2,4, 102,103, 104, 4, 200, 1, 3, 2};

        System.out.println(longestByOptimal(arr));
    }

    public static int longestByOptimal(int[] nums) {
        if (nums.length == 0) return 0;

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : set) {
            if (!set.contains(num -1 )) {
                int x = num;
                int cnt = 1;

                while (set.contains(x + 1)) {
                    x++;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static int longestByBetter(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int longest = 1;
        int currCount = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                currCount += 1;
                lastSmaller = nums[i];
            } else if (lastSmaller != nums[i]) {
                currCount = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, currCount);
        }
        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int cnt = 1;
            while (!linearSearch(nums, x)) {
                x++;
                cnt++;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    private static boolean linearSearch(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return true;
            }
        }
        return false;
    }
}
