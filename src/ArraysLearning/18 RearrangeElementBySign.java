package ArraysLearning;

import java.util.ArrayList;
import java.util.List;

 class RearrangeElementBySign {
    public static void main(String[] args) {

    }

    //this is for unequal number of +ve and -ve
    public static void rearrangingByBrute(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg.add(nums.length);
            } else {
                pos.add(nums[i]);
            }
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = neg.size() * 2;
            for (int i = 0; i < pos.size(); i++) {
                nums[index] = pos.get(i);
                index++;
            }

        } else {
            for (int i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = pos.size() * 2;
            for (int i = 0; i < neg.size(); i++) {
                nums[index] = neg.get(i);
                index++;
            }
        }
    }


    // this two solution for the equal number of +ve and -ve
    public static int[] rearrangingByOptimal(int[] nums) {
        int[] ansArr = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ansArr[neg] = nums[i];
                neg += 2;
            } else {
                ansArr[pos] = nums[i];
                pos += 2;
            }
        }
        return ansArr;
    }

    public static void rearrangeElementBySign(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int k = 0, j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg[k] = nums[i];
                k++;
            }else {
                pos[j] = nums[i];
                j++;
            }
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = pos[i];
            nums[i+1] = neg[i];
        }
    }
}
