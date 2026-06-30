package ArraysLearning;

import java.util.ArrayList;
import java.util.List;

 class PascalsTriangle {
    public static void main(String[] args) {

        printPascalsRow(6);
    }

    //3. return a list that have all elements for given row
    public static List<List<Integer>> getElementsInPascalsTriangle(int row) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            ans.add(generateRow(i));
        }
        return ans;
    }

    private static List<Integer> generateRow(int row){
        List<Integer> rowList = new ArrayList<>();
        rowList.add(1);
        int ans = 1;
        for (int col = 1; col < row; col++) {
            ans *= (row - col);
            ans /= (col);
            rowList.add( ans);
        }
        return rowList;
    }

    //2. print any given row that provided by user
    public static void printPascalsRow(int row) {
        //formula is first print 1
        //after that we observe that for loops start from 1 to n
        //so this is col that will always divide the answer
        //and int numrator always multiply ( n - i )

        int ans = 1;
        System.out.print(ans + " ");
        for (int col = 1; col < row - 1; col++) {
            ans *= (row - col);
            ans /= (col);
            System.out.print(ans + " ");
        }
        System.out.println("1");
    }

    //1. Given no. of row and element position than find that element
    public static long findNumberFromTriangle(int row, int pos) {
        // we only have to find the combination of row-1 and pos-1
       return NcR((row - 1), (pos - 1));
    }

    private static long NcR(int n, int r) {
        // for example n = 10 and r = 3
        //than 10 - 3 = 7! is always cancel out 10*9*8 / 1*2*3
        long result = 1;
        for (int i = 0; i < r; i++) {
            result  *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
