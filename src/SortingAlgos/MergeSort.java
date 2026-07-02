package SortingAlgos;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int [] numbs = {13, 46, 24, 52, 20, 9};
        mergeSort(numbs,0, numbs.length-1);
        for (int num : numbs) {
            System.out.println(num);
        }
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

    public static void mergeSort(int[] numbs, int low, int high) {
        if (low == high) return;
        int mid = (low + high) / 2;
        mergeSort(numbs,low, mid);
        mergeSort(numbs, mid+1, high);
        merge(numbs, low, mid, high);
    }
}
