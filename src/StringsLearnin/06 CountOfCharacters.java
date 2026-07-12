package StringsLearnin;

 class CountOfCharacters {
    public static void main(String[] args) {
        System.out.println(getCount("Hello worl d"));
    }

    public static int getCount(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                cnt++;
            }
        }
        return cnt;
    }
}
