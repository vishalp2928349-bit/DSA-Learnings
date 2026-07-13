package StringsLearnin;

 class EquivalentString {
    public static void main(String[] args) {
        String str1 = "abcdeef";
        String str2 = "abaaacc";
        System.out.println(isEquivString(str1, str2));
    }

    public static boolean isEquivString(String word1, String word2) {
        int[] hash = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            hash[word1.charAt(i) - 'a']++;
            hash[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (Math.abs(hash[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
