package StringsLearnin;

 class FirstIndexOfOccurrence {
    public static void main(String[] args) {
        String str = "sadbutsad";
        String needle = "sad";
        System.out.println(getFirstOccurrence(str, needle));
    }

    public static int getFirstOccurrence(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length()+i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
