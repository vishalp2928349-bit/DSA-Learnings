package ArraysLearning;

 class FindNextPermutation {
    public static void main(String[] args) {

//        int[] nums = {2,1,5,4,3,0,0};
        int[] nums = {3,2,1};
        int[] newNum = nextPermutation(nums);
        for (int num : newNum) {
            System.out.print(num + " ");
        }

    }

    public static int[] nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverseArr(nums, 0, n-1);
            return nums;
        }

        for (int i = n-1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverseArr(nums, idx+1, n-1);
        return nums;
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

    /*
    ex -> [2, 1 ||||, 5, 4, 3, 0, 0]
                  ^ is breakpoint a[i] = 1
    fistly find greater than 1 but smallest from remaining one
    i.e., 3 so putting like -> [2, 3, _,_,_,_,_ ]

    so from this now we have to find smallest from remaining
    i.e., from 5,4,1,0,0 -> 0 or may be we can say doing by sorted manner
    so put 0,0,1,4,5 at 2,3
     */

    /*
    Optimal solution is :
    1. find the longest prefix match (ex. raj, ram has ra longest prefix macth)
        a[i] < a[i + 1] find breakpoint
    2. a[j] > a[i] (finded Number) but smallest one
        stay close to the a[i] number
    3. try to place remaining elements in sorted manner

     */

    /*
    if we using library on c++ then we can directly find next permutation
     */

    /*
    brute force sol is :
    1. generate all the permutation in sorted manner
    2. do linear search on all this permutations
    3. gave the next index of that permutation (given to next)

    but it take a lot of time
     */
}
