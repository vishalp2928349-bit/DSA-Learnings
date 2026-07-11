package StringLearningFromSharma;

 class ConsecutiveCharacter {
    public static void main(String[] args) {

    }

    public static int getCount(String str) {
        int maxLen = 1;
        int x = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == str.charAt(i)) {
                x++;
            } else {
                maxLen = Math.max(maxLen, x);
                x = 1;
            }
        }
        return maxLen;
    }
}
