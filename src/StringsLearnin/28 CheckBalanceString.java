package StringsLearnin;

 class CheckBalanceString {
    public static void main(String[] args) {
        System.out.println(isBalanceString("24123"));
    }

    public static boolean isBalanceString(String num) {
        long sumO = 0;
        long sumE = 0;

        for (int i = 0; i < num.length(); i = i+2) {
            sumE += num.charAt(i) - '0';
            if (i+1 < num.length()) {
                sumO += num.charAt(i+1) - '0';
            }
        }
        System.out.println(sumE + " " + sumO);
        if (sumE != sumO) return false;
        return true;
    }
}
