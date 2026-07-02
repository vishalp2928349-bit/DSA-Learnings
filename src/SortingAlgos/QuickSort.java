package SortingAlgos;

public class QuickSort {
    public static void main(String[] args) {
        int [] numbs = {13, 46, 24, 52, 20, 9};
        qs(numbs, 0, numbs.length-1);
        for (int num : numbs) {
            System.out.println(num);
        }
    }

    private static int partition(int[] numbs, int low, int high) {
        int pivot = numbs[low]; //first element to be pivot
        int i = low;
        int j = high;

        while (i < j) {
            // find first element greater than pivot
            while (i <= high-1 && numbs[i] <= pivot) {
                i++;
            }
            //find first element less than pivot
            while (j >= low+1 && numbs[j] > pivot) {
                j--;
            }
            //swap that i and j position values
            if (i < j) {
                int temp = numbs[i];
                numbs[i] = numbs[j];
                numbs[j] = temp;
            }
        }
        //now swap pivot with j
        int temp = numbs[low];
        numbs[low] = numbs[j];
        numbs[j] = temp;
        return j;
    }

    public static void qs(int[] numbs, int low, int high)   {
        int n = numbs.length;
        if (low < high) {
            //it gives first partition an array
            int partition = partition(numbs, low, high);
            //sorting for left array
            qs(numbs, low, partition-1);
            // sorting for right array
            qs(numbs, partition+1, high);
        }
    }
}
