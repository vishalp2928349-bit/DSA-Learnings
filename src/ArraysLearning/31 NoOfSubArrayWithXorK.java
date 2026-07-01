package ArraysLearning;

import java.util.HashMap;

 class NoOfSubArrayWithXorK {
    public static void main(String[] args) {
        String str = "hello";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

    }

    public static int getSubarrayByOptimal(int[] nums, int k) {
        int xr = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            xr = xr ^ nums[i];
            int x = xr ^ k;
            cnt = hashMap.getOrDefault(x, 0) +1;
            hashMap.put(xr, hashMap.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }

    public static int getSubarrayByBetter(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = 0; j < n; j++) {
                xor = xor ^ nums[j];
                if (xor == k) cnt++;
            }
        }

        return cnt;
    }

    public static int getNoOfSubarray(int[] nums, int target) {
        int cnt = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ nums[k];
                    if (xor == target) cnt++;
                }
            }
        }
        return cnt;
    }
}
