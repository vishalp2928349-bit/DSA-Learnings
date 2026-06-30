package ArraysLearning;

 class SetMatrixZero {
    public static void main(String[] args) {
        int[][] nums = {{1,1,1,1},
                        {1,0,1,1},
                        {1,1,0,1},
                        {0,1,1,1}};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("new matrix: ");
//        setMatrixZeroByOptimal(nums);
//        setMatrixZero(nums);
        setMatrixZeroByBetter(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZeroByOptimal(int[][] nums) {
//        int[] row = new int[nums.length]; -> matrix[..][0]
//        int[] col = new int[nums[0].length]; -> matrix[0][..]
        int col0 = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    //mark ith row
                    nums[i][0] = 0;
                    //mark jth col
                    //condition for first col to be 0 or not
                    if (j != 0) nums[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                if (nums[i][j] != 0) {
                    //check for row and col
                    if (nums[0][j] == 0 || nums[i][0] == 0) {
                        nums[i][j] = 0;
                    }
                }
            }
        }

        if (nums[0][0] == 0){
            for (int j = 0; j < nums.length; j++) {
                nums[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < nums[0].length; i++) {
                nums[i][0] =0;
            }
        }
    }

    public static void setMatrixZeroByBetter(int[][] nums) {
        int[] row = new int[nums.length];
        int[] col = new int[nums[0].length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    nums[i][j] = 0;
                }
            }
        }
    }
    
    public static void setMatrixZero(int[][] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    markRow(nums, i);
                    markCol(nums, j);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == -1) {
                    nums[i][j] = 0;
                }
            }
        }
    }

    private static void markRow(int[][] nums, int i) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[i][j] != 0) {
                nums[i][j] = -1;
            }
        }
    }

    private static void markCol(int[][] nums, int j) {
        for (int i = 0; i < nums[0].length; i++) {
            if (nums[i][j] != 0) {
                nums[i][j] = -1;
            }
        }
    }
}
