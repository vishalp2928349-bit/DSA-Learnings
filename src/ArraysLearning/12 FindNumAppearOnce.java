package ArraysLearning;

import java.util.HashMap;
import java.util.Map;

class FindNumAppearOnce {

     public static void main(String[] args) {
         int[] nums = {1,1,3,4,3,5,4,6,6};

         int num = findNumAppearOnce(nums);
         System.out.println(num);

         num = findByBetter(nums);
         System.out.println(num);

         num = findByBetter(nums);
         System.out.println(num);

         num = findByOptimalXor(nums);
         System.out.println(num);
     }

     public static int findByOptimalXor(int[] nums) {
         int xor = 0;
         for (int i = 0; i < nums.length; i++) {
             xor ^= nums[i];
         }
         return xor;
     }

     public static int findByMap(int[] nums) {
         Map<Integer, Integer> mapping = new HashMap<>();

         for (int num : nums) {
             mapping.put(num, mapping.getOrDefault(num, 0) + 1);
         }

         for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
             if (entry.getValue() == 1) {
                 return entry.getKey();
             }
         }

         return -1;

         //time - n log m + O( n/2 + 1) for mapping
         //space - O(n/2 +1 )
     }

     public static int findByBetter(int[] nums)     {
         int maxi = nums[0];
         for (int i = 0; i < nums.length; i++) {
             maxi = Math.max(maxi, nums[i]);
         }
//         System.out.println(maxi);
         int[] hashing = new int[maxi + 1];

         for (int i = 0; i < nums.length; i++) {
             hashing[nums[i]] ++;
//             System.out.println(i);
         }

         for (int i = 0; i < hashing.length; i++) {
             if (hashing[i] == 1) {
                 return i;
             }
         }
         return -1;
     }

     public static int findNumAppearOnce(int[] nums) {

         for (int i = 0; i < nums.length; i++) {
             int num = nums[i];
             int cnt = 0;
             for (int j = 0; j < nums.length; j++) {
                 if (nums[j] == num) {
                     cnt++;
                 }
             }
             if (cnt == 1) {
                 return num;
             }
         }
         return -1;
     }
}
