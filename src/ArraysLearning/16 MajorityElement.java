package ArraysLearning;

import java.util.HashMap;
import java.util.Map;

 class MajorityElement {
    public static void main(String[] args) {

        int[] nums = {5,5,7,7,3,5,2,4,5,5,3,5,5,7,5};
       int num = majorityByOptimal(nums);
        System.out.println(num);
    }

    public static int majorityByOptimal(int[] nums) {
        int cnt = 0;
        int element = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt++;
                element = nums[i];
            } else if (nums[i] == element) {
                cnt++;
            } else  {
                cnt--;
            }
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count++;
        }
        if (count > nums.length) {
            return element;
        }
        return -1;
    }

    public static int majorityByBetter(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //inserting element with their count in map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        /// find count that appears majority times
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityByBrute(int[] nums) {
        int cnt;
        for (int i = 0; i <nums.length; i++) {
            cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            if (cnt > nums.length / 2) return nums[i];
        }
        return -1;
    }
}
