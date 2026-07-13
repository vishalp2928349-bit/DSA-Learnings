package StringsLearnin;

import java.util.HashMap;

 class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
    }

    public static boolean validAnagram(String str, String target) {
        if (str.length() != target.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map1.put(str.charAt(i), map1.getOrDefault(str.charAt(i), 0) + 1);
            map2.put(target.charAt(i), map2.getOrDefault(target.charAt(i), 0) + 1);
        }
        if (map1.equals(map2)) return true;

        return false;
    }
}
