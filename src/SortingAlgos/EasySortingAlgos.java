package SortingAlgos;

public class EasySortingAlgos {

    public static void main(String[] args) {
        int [] numbs = {13, 46, 24, 52, 20, 9};
        insertionSort(numbs);
        for (int num : numbs) {
            System.out.println(num);
        }
    }

    public static void insertionSort(int[] numbs) {
        int n = numbs.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && numbs[j-1] > numbs[j]) {
                int temp = numbs[j-1];
                numbs[j-1] = numbs[j];
                numbs[j] = temp;
                j--;
            }
        }
    }


    public static void selectionSort(int[] numbs) {
        int n = numbs.length;

        for (int i = 0; i < n - 1; i++) {
            int mini = i;
            for (int j = 0; j < n; j++) {
                if (numbs[j] < numbs[mini]) mini = j;
            }
            if (mini != i) {
                int temp = numbs[mini];
                numbs[mini] = numbs[i];
                numbs[i] = temp;
            }
        }
    }

    public static void bubbleSort(int[] numbs) {
        int n = numbs.length;
        for (int i = n-1 ; i >= 0; i--) {
            int flag = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (numbs[j] > numbs[j+1]) {
                    int temp = numbs[j];
                    numbs[j] = numbs[j+1];
                    numbs[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) break;
        }
    }
}
