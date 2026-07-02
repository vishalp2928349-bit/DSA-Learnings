package ArraysLearning;

import java.util.ArrayList;
import java.util.List;

 class ReversePairs {
    public static void main(String[] args) {

    }

    public static void merge(int[] numbs, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high) {
            if (numbs[left] <= numbs[right]) {
                temp.add(numbs[left]);
                left++;
            } else {
                temp.add(numbs[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(numbs[left]);
            left++;
        }

        while (right <= high) {
            temp.add(numbs[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            numbs[i] = temp.get(i-low);
        }
    }

    private static int countPairs(int[] numbs, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = 0; i < mid; i++) {
            while (right <= high && (long) numbs[i] > ((long) 2 * numbs[right])) right++;
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    public static int mergeSort(int[] numbs, int low, int high) {
        int cnt = 0;
        if (low == high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(numbs,low, mid);
        cnt += mergeSort(numbs, mid+1, high);
        cnt += countPairs(numbs, low, mid, high);
        merge(numbs, low, mid, high);
        return cnt;
    }

    public static int getPairsByOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int getReversePairsCount(int[] numbs) {
        int cnt = 0;
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i+1; j < numbs.length; j++) {
                if (numbs[i] > (2 * numbs[j])) cnt++;
            }
        }
        return cnt;
    }
}
