package StringsLearnin;

import java.util.*;

 class ConcatenatedWord {
    public static void main(String[] args) {

        String[] strs = {"cat", "dog", "dogcat", "catdog"};
        System.out.println(findAllConcatenatedWords(strs));
    }

    public static List<String> findAllConcatenatedWords(String[] words) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(words));
        //or 
//        for (int i = 0; i < words.length; i++) {
//            set.add(words[i]);
//        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isConcatenated(words[i], set, hashMap)) {
                resultList.add(words[i]);
            }
        }
        return resultList;
    }
    
    private static boolean isConcatenated(String word, Set<String> st, HashMap<String, Boolean> hm) {
        if (hm.containsKey(word)) {
            return hm.get(word);
        }

        for (int i = 0; i < word.length(); i++) {
            String prefix = word.substring(0, i+1);
            String suffix = word.substring(i+1, word.length());

            if (st.contains(prefix) && st.contains(suffix)
                    || st.contains(prefix) && isConcatenated(suffix, st, hm)) {
                hm.put(word, true);
                return true;
            }
        }
        hm.put(word, false);
        return false;
    }
}
