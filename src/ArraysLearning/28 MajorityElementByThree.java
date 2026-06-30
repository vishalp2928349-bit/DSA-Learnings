package ArraysLearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 class MajorityElementByThree {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,2,2,2};
//        List<Integer> lists = getMajorityByBetter(nums);
//        for (int num : lists) {
//            System.out.println(num);
//        }

        List<Integer> lists = getMajorityByOptimal(nums);
        for (int num : lists) {
            System.out.println(num);
        }



    }

    public static List<Integer> getMajorityByOptimal(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (el1 == nums[i]) {
                cnt1++;
            } else if (el2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

//        System.out.println(el1 + " " + el2);
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (el1 == nums[i]) cnt1++;
            if (el2 == nums[i]) cnt2++;
        }

        if (cnt1 > nums.length/3) list.add(el1);
        if (cnt2 > nums.length/3) list.add(el2);
        return list;
    }

    public static List<Integer> getMajorityByBetter(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = (nums.length/3) + 1;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 3) {
                list.add(nums[i]);
            }
            if (list.size() == 2) return list;
        }
        return list;
    }

    public static List<Integer> getMajorityElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (list.isEmpty() || !list.contains(nums[i])) {
                int cnt = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        cnt++;
                    }
                }
                if (cnt > nums.length/3) {
                    list.add(nums[i]);
                }
            }
        }
        return list;
    }
}
