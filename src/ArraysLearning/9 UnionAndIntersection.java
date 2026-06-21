package ArraysLearning;

import java.util.ArrayList;
import java.util.Collection;

class UnionAndIntersection {
    public static void main(String[] args) {

        int[] num1 = {1,1,2,2,3,4,4,5};
        int[] num2 = {2,2,3,4,5,6,7};

        System.out.print("Union: ");
        Collection<Integer> newArr = unionArrays(num1, num2);
        for (Integer num : newArr) {
            System.out.print(num + " ");
        }

//        newArr = intersectionArray(num1,num2);
        newArr = interByOptimal(num1,num2);
        System.out.print("\nIntersection: ");
        for (Integer num : newArr) {
            System.out.print(num + " ");
        }
    }

    public static Collection<Integer> unionArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        Collection<Integer> unionArr = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (unionArr.isEmpty() || !unionArr.contains(nums1[i])) {
                    unionArr.add(nums1[i]);
                }
                i++;
            } else {
                if (unionArr.isEmpty() || !unionArr.contains(nums2[j])) {
                    unionArr.add(nums2[j]);
                }
                j++;
            }
        }

        while (j < nums2.length) {
            if (unionArr.isEmpty() || !unionArr.contains(nums2[j])) {
                unionArr.add(nums2[j]);
            }
            j++;
        }

        while (i < nums1.length) {
            if (unionArr.isEmpty() || !unionArr.contains(nums1[i])) {
                unionArr.add(nums1[i]);
            }
            i++;
        }

        return unionArr;
    }

    public static Collection<Integer> intersectionArray(int[] num1, int[] num2) {
        //array created with value 0
        int[] visited = new int[num2.length];
        Collection<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]
                        && visited[j] == 0) {
                    intersection.add(num1[i]);
                    visited[j] = 1;
                    break;
                }
                if (num2[j] > num1[i]) break;
            }
        }

       return intersection;
    }

    public static Collection<Integer> interByOptimal(int[] num1, int[] num2) {
        int j = 0, i = 0;
        Collection<Integer> inter = new ArrayList<>();

        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            } else if (num2[j] < num1[i]) {
                j++;
            } else {
                inter.add(num1[i]);
            }
        }

        return inter;
    }
}
