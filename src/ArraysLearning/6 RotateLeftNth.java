package ArraysLearning;

class RotateLeftNth {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
//        rotateLeft(nums, 4);
        rotateLeftByOptimal(nums, 3);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void rotateLeftByOptimal(int[] nums, int dth) {
        int size = nums.length;
        dth = dth % size;
        if (dth == 0) return;

        reverseArr(nums, 0, (dth - 1 ));
        reverseArr(nums, dth, (size - 1) );
        reverseArr(nums, 0, (size - 1));
    }

    public static void reverseArr(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateLeft(int[] nums, int d) {
        int size = nums.length;
        d = d % size;
        if (d == 0) return;
        //temp array
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = nums[i];
        }

        //rotate remaining numbers
        for (int i = d ; i < size; i++) {
            nums[i-d] = nums[i];
        }

        //rotate temp numbers at last
//        int j = 0;
        for (int i = (size - d); i < size; i++) {
            nums[i] = temp[i-(size-d)];
//            j++;
        }
    }

}
