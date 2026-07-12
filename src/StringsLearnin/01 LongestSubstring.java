package StringsLearnin;

import java.util.HashMap;

 class LongestSubstring {
    public static void main(String[] args) {

        int count = getLongestSubstring("cadbzzabczd");
        System.out.println(count);
    }

    public static int getByOptimal(String str) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            if (hash.containsKey(c) && hash.get(c) >= left) {
                left = hash.get(c) + 1;
            }
            hash.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int getLongestSubstring(String str) {
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] hash = new int[255];
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                if (hash[str.charAt(j)] == 1) break;
                len = j - i + 1;
                maxLen = Math.max(maxLen, len);
                hash[str.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
}
