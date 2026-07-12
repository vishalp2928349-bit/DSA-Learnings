package StringsLearnin;

import java.util.Arrays;

 class CheckAnagramString {
    public static void main(String[] args) {
        String str1 = "keep";
        System.out.println(isAnagram("keep", "peek"));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        if (Arrays.equals(c1, c2)) return true;

        return false;
    }
}
