package ArraysLearning;

import java.util.*;

 class FourSumProblem {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getQuadrupletsByOptimal(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ( i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;

                while (k < l) {

                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        list.add(temp);
                        k++;
                        l--;
                        while ( k < l && nums[k] == nums[k-1]) k++;
                        while (k < l && nums[l] == nums[l+1]) l--;

                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> getQuadrupletsByBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Set<Integer> hashSet = new HashSet<>();
                for (int k = j+1; k < n; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;
                    if (hashSet.contains((int) fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);

                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashSet.add(nums[k]);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }

    public static List<List<Integer>> getQuadruplets(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[l];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
}
