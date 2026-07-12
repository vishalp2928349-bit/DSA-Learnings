package StringsLearnin;

 class ReverseOrderOfWords {
    public static void main(String[] args) {

    }

    public static String getReverseWords(String s) {
        String[] str = s.split(" +");
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            newStr.append(str[i]).append(" ");
        }
        return newStr.toString().trim();
    }
}
