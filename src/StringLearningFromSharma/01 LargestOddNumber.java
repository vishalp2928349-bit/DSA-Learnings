package StringLearningFromSharma;

 class LargestOddNumber {
    public static void main(String[] args) {
        String str = "246872";
        System.out.println(largestOddNum(str));
    }

    public static String largestOddNum(String str) {
        for (int i = str.length() -1 ; i >= 0; i--) {
            if (str.charAt(i) % 2 != 0) {
                return str.substring(0,i+1);
            }
        }
        return "";
    }
}
