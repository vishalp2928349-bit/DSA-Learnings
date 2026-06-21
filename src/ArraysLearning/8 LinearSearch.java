package ArraysLearning;

class LinearSearch {
    public static void main(String[] args) {

    }

    public static int linerSearch(int[] nums, int a) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                return i;
            }
        }
        return -1;
    }
}
