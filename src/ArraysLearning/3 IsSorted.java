package ArraysLearning;

class IsSorted {

    public boolean isSorted(int[] nums) {
        if (isDecreasing(nums) || isIncreasing(nums)) {
            return true;
        }
        return false;
    }

    private boolean isDecreasing(int[] nums) {
        if (nums.length <= 1) return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isIncreasing(int[] nums) {
        if (nums.length <= 1) return true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
