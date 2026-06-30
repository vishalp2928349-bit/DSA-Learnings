package ArraysLearning;

class MoveZerosToLast {

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,4,0,0,4,5};
        moveZerosLast(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void moveZerosLast(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        for (int i = j+1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }
}
