package StringsLearnin;

 class CheckForPrefixPresent {
    public static void main(String[] args) {
        System.out.println(checkPrefix("i love to code leetcode", "leets"));
    }

    public static int checkPrefix(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}
