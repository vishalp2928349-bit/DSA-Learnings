package ArraysLearning;

class SLargestAndSSmallest {

    public int sLargestNum(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int sLarge = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                sLarge = largest;
                largest = nums[i];
            } else if (nums[i] > sLarge && nums[i] < largest) {
                sLarge = nums[i];
            }
        }
        return sLarge;
    }

    public int sSmallestNum (int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int sSmall = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < smallest) {
                sSmall = smallest;
                smallest = nums[i];
            } else if (nums[i] < sSmall && nums[i] != smallest) {
                sSmall = nums[i];
            }
        }
        return sSmall;
    }
}
