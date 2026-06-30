package ArraysLearning;

import java.util.*;

 class ThreeSumProblem {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        List<List<Integer>> list = getTripletsByBetter(nums);
//        for (List num : list) {
//            System.out.println(num);
//        }

        int[] newNums = {0, -1, -2, 2, -1, 0, 2, 0, -1, -2, 2, -2};
        List<List<Integer>> list = getTripletByOptimal(newNums);
        for (List num : list) {
            System.out.println(num);
        }

    }

    public static List<List<Integer>> getTripletByOptimal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    list.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> getTripletsByBetter(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = - (nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    public static List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempSet = new ArrayList<>();
                        tempSet.add(nums[i]);
                        tempSet.add(nums[j]);
                        tempSet.add((nums[k]));
                        Collections.sort(tempSet);
                        list.add(tempSet);
                    }
                }
            }
        }

        return list;
    }
}
