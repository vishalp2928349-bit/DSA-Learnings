package ArraysLearning;

import java.util.ArrayList;
import java.util.List;

 class LeadersInArray {
    public static void main(String[] args) {

    }

    public static int[] findLeaderByOptimal(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;

        for (int i = nums.length -1 ; i >= 0; i--) {

            if (nums[i] > maxi) {
                list.add(nums[i]);
            }
            maxi = Math.max(maxi, nums[i]);
        }
        int i =0;
        int[] newArr = new int[list.size()];
        for (int num : list) {
            newArr[i] = num;
            i++;
        }
        return newArr;
    }

    public static int[] findLeader(int[] nums) {
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    break;
                }
                newList.add(nums[i]);
            }
        }

        int[] newArr = new int[newList.size()];
        int i = 0;
        for (int num : newList) {
            newArr[i] = num;
            i++;
        }
        return newArr;
    }
}
