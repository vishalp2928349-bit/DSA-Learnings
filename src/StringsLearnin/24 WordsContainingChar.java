package StringsLearnin;

import java.util.ArrayList;
import java.util.List;

 class WordsContainingChar {
    public static void main(String[] args) {
        String[] strs = {"leetcode", "code", "sce"};
        System.out.println(isContainsChar(strs, 'e'));
    }

    public static List<Integer> isContainingByOptimal(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> isContainsChar(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == x) {
                    result.add(i);
                    break;
                }
            }
        }

        return result;
    }
}
