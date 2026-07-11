package StringLearningFromSharma;

 class MaxNestingParenthesis {
    public static void main(String[] args) {
        String str = "(1+(1-1)*da(asc(cas)scx))";
        System.out.println(getMax(str));
    }

    public static int getMax(String str) {
        int result = 0;
        int curr = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                result = Math.max(++curr, result);
            } else if (str.charAt(i) == ')'){
                curr--;
            }
        }
        return Math.max(curr, result);
    }
}
