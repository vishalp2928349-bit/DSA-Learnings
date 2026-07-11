package StringLearningFromSharma;

 class LongestPalindromeSubString {
    public static void main(String[] args) {

    }

    private static int expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() &&
                    str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String getPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i); // Odd length
            int len2 = expandFromCenter(s,i, i+1); //even length
            int len = Math.max(len1, len2);

            if (len > end - start +1) {
                start = i - (len - 1)/ 2;
                end = i + len /2;
            }
        }

        return s.substring(start, end+1);
    }
}
