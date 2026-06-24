package ArraysLearning;

 class Sort0s1s2s {
    public static void main(String[] args) {

    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length -1;
        if (nums.length <= 1) return;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    public static void sortColorByBetter(int[] nums) {
        int zero = 0, one = 0, two =0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for (int i = zero; i < (zero + one) ; i++){
            nums[i] = 1;
        }
        for (int i = (zero + one); i < nums.length; i++) {
            nums[i] = 2;
        }
    }







    /* Dutch National Flag Algorithm
    0 -> low-1 = 0s ----sorted
    low -> mid-1 = 1s ----sorted
    mid -> high = unsorted
    high+1 -> n-1 = 2s ----sorted

    starting: low = 0; mid = 0; high = n - 1;

    for 0 -> swap(low , mid) mid++, low++
    for 1 -> do nothing and mid++
    for 2 -> swap(mid, high) high--
     */
}
