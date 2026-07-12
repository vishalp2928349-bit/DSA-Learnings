package StringsLearnin;

 class ReverseString {
    public static void main(String[] args) {

        System.out.println(reverseString("INTERVIEW  "));
    }

    public static String reverseString(String str) {
        /*
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
         */

        if (str.length() == 1) return str;
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }
}
