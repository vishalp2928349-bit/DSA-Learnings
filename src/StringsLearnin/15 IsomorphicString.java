package StringsLearnin;

import java.util.HashMap;

 class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ega", "adb"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> hashing = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (hashing.containsKey(s.charAt(i))) {
                if (!hashing.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                if (hashing.containsValue(t.charAt(i))) {
                    return false;
                }
                hashing.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
