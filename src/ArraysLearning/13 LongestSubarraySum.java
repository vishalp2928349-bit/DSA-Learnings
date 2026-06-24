package ArraysLearning;

import java.util.HashMap;
import java.util.Map;

class LongestSubarraySum {

 public static void main(String[] args) {
  int[] nums = {1,2,3,1,1,1,3,4,5,1};
  int num = findByBetter(nums, 4);
  System.out.println(num);

  findSubArray(nums, 4);

  num = findByOptimal(nums, 4);
  System.out.println(num);
 }

 public static int findByOptimal(int[] nums, int k) {
  int left =0, right = 0;
  long sum =0;
  int maxLen = 0;

  while (right < nums.length) {
   while (left <= right && sum > k) {
    sum -= nums[left];
    left++;
   }

   if (sum == k) {
    maxLen = Math.max(maxLen, (right - left + 1));
   }

   right++;
   if (right < nums.length) {
    sum += nums[right];
   }

  }
  return maxLen;
 }

     public static int findByBetter(int[] nums, int k) {
     Map<Long, Integer> preSum = new HashMap<>();
      int maxLen = 0;
      long sum = 0;

      for (int i = 0; i < nums.length; i++) {
       sum += nums[i];

       // If the sum from index 0 to i equals k
       if (sum == k) {
        maxLen = i+1;
//        maxLen = Math.max(maxLen, i+1);
       }

       long rem = sum - k;
       // Check if there exists a prefix sum = sum - k
       if (preSum.containsKey(rem)) {
        int len = i - preSum.get(rem);
        maxLen = Math.max(maxLen, len);
       }

       // Store the first occurrence of the prefix sum
       if (!preSum.containsKey(sum)) {
        preSum.put(sum, i);
       }
      }


  return maxLen;
 }

 public static void findSubArray(int[] nums, int add) {
  int leg = 0;
  for (int i = 0; i < nums.length; i++) {
   int sum = 0;
   for (int j = i; j < nums.length; j++) {

     sum += nums[j];
     if (sum == add) {
      leg = Math.max(leg, (j - i +1));
     }
   }
  }
  System.out.println(leg);
 }
}
