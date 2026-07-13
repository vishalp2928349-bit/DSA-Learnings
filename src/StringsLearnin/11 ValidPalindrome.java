package StringsLearnin;

 class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeString("A man, a plan a canal: panama"));
    }

    public static boolean isPalindromeString(String s) {
        String str = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        int n = str.length();
        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
