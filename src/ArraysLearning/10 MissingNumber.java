package ArraysLearning;

 class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {1,4,3,5};
        int missNum = missByXor(nums, 5);
        System.out.println(missNum);

        missNum = missNumBetter(nums,5);
        System.out.println(missNum);

        missNum = missNumberBrute(nums, 5);
        System.out.println(missNum);

        missNum = missBySum(nums, 5);
        System.out.println(missNum);
    }


    public static int missByXor(int[] nums, int n) {
        int xor1 = 0 , xor2 = 0;

        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }
        xor2 = xor2 ^ n;

        return xor1 ^ xor2;
        //time - O(n)
        //space - O(1)
        //but it is better because it only uses 10^5 max space
        //in sum it may be goes to 10^5 to 10^10
        //10^5 * (10^5 + 1) / 2 ~ 10^5
    }

    public static int missBySum(int[] nums, int n) {
        int sum = (n * (n + 1)) / 2;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }

        return (sum - sum2);
    }

    public static int missNumBetter(int[] nums, int n) {
        int[] hash = new int[n + 1];

        //hashing with 1
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] = 1;
        }

        //finding 0 in hash
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
        //time - O(2n)
        //space - O(n)
    }

    public static int missNumberBrute(int[] nums, int n) {

        for (int i = 1; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return 0;
    }

}
