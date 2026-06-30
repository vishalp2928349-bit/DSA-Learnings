package ArraysLearning;

 class RotateMatrixBy90d {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("New Matrix: ");
        rotateMatrixByOptimal(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateMatrixByOptimal(int[][] matrix) {
        //transpose the matrix
        //after that reverse the matrix by rows
        int n = matrix.length;
        int m = matrix[0].length;
        //transpose
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        // reverse by rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(m-1)-j];
                matrix[i][(m-1)-j] = temp;
            }
        }
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        int[][] ansArr = new int[matrix.length][matrix[0].length];
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ansArr[j][(n-1)-i] = matrix[i][j];
            }
        }
        return ansArr;
    }
}
