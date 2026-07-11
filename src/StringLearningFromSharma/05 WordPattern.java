package StringLearningFromSharma;

import java.util.HashMap;

 class WordPattern {
    public static void main(String[] args) {
        String str = "abba";
        String word = "dog cat cat dog";
        System.out.println(isPattern(str,word));
        System.out.println(isPatternByOptimal(str,word));
    }

    //if split function is not allowed
     private static String[] getWords(String str) {
        int count = 1;
         for (int i = 0; i < str.length(); i++) {
             if (str.charAt(i) == ' ') count++;
         }
         String[] words = new String[count];

         int index = 0, start = 0;
         for (int i = 0; i <= str.length(); i++) {
             if (i == str.length() || str.charAt(i) == ' ') {
                 words[index++] = str.substring(start, i);
                 start = i+1;
             }
         }
         return words;
     }

    public static boolean isPatternByOptimal(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            Integer p = map.put(pattern.charAt(i), i);
            Integer w = map.put(words[i], i);

            if (p != w) return false;
        }
        return true;
    }

    public static boolean isPattern(String pattern, String word) {
        String[] words = word.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(w)) return false;
            } else {
                charToWord.put(ch, w);
            }

            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != ch) return false;
            } else {
                wordToChar.put(w,ch);
            }
        }
        return true;
    }
}
