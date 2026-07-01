package ArraysLearning;

import java.util.Arrays;

 class MergeTwoSortedArray {
    public static void main(String[] args) {

    }

    public static void mergeByBetter(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int left = n-1, right = 0;

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n + m];
        int left = 0, right = 0, index = 0;

        while (left < n && right < m) {
            if (arr1[left] < arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }

        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        while (left < n) {
            arr3[index++] = arr1[left++];
        }
        index = 0;
        for (int i = 0; i < n + m; i++) {
            if (i < n) arr1[i] = arr3[i];
            else arr2[i - n] = arr3[i];
        }
    }
}
