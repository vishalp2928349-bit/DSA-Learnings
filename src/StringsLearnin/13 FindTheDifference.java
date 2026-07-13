package StringsLearnin;

 class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findDifference("bcd", "abcd"));
    }

    public static char findDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        long targetSum = 0;
        long stringSum = 0;
        for (int i = 0; i < s.length(); i++) {
            stringSum += s.charAt(i);
            targetSum += t.charAt(i);
        }
        targetSum += t.charAt(t.length()-1);
        int diff = (int) (targetSum-stringSum);

        return (char) diff;
    }
}
