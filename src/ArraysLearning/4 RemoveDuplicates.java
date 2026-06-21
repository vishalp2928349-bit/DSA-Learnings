package ArraysLearning;



import java.util.HashSet;
import java.util.Set;

class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3,3,4};
//        int size = RemoveDuplicates.removeByBrute(nums);
        int size = removeByOptimal(nums);
        for (int i = 0; i < size; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeByOptimal(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return (i+1);
    }

    public static int removeByBrute(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int idx = 0;
        for(Integer num : numSet) {
            nums[idx] = num;
            idx++;
        }

        return numSet.size();
    }
}
