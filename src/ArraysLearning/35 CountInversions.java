package ArraysLearning;

import java.util.ArrayList;
import java.util.List;

class CountInversions {
    public static void main(String[] args) {
        int[] numbs = {5,3,2,4,1};
//        int cnt = getCountInversion(numbs);
        int cnt = getCountByOptimal(numbs);
        System.out.println(cnt);
    }

    public static int merge(int[] numbs, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int cnt = 0;
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high) {
            if (numbs[left] <= numbs[right]) {
                temp.add(numbs[left]);
                left++;
            } else {
                cnt += (mid - left + 1);
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

        return cnt;
    }

    public static int mergeSort(int[] numbs, int low, int high) {
        int cnt = 0;
        if (low == high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(numbs,low, mid);
        cnt += mergeSort(numbs, mid+1, high);
        cnt += merge(numbs, low, mid, high);
        return cnt;
    }

    public static int getCountByOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int getCountInversion(int[] numbs) {
        int cnt = 0;
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i+1; j < numbs.length; j++) {
                if (numbs[i] > numbs[j]) cnt++;
            }
        }
        return cnt;
    }
}
