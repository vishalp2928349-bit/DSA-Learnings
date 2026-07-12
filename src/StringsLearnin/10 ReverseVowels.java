package StringsLearnin;

 class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowel("hello"));
    }

    private static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) {
            return true;
        }
        return false;
    }

    public static String reverseVowel(String str) {
        if (str.length() < 2) return str;

        char[] ch = str.toCharArray();
        int start = 0;
        int end = ch.length-1;

        while (start < end) {
            if (!isVowel(ch[start])) {
                start++;
            } else if (!isVowel(ch[end])) {
                end--;
            } else {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
