package StringsLearnin;

 class ReverseOnlyLetter {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetter("ab-cd"));
    }

    public static String reverseOnlyLetter(String s) {
        if (s.length() < 2) return s;
        int start = 0;
        int end = s.length()-1;
        char[] arr = s.toCharArray();

        while (start < end) {
            if (!Character.isLetter(arr[start])) {
                start++;
            } else if (!Character.isLetter(arr[end])) {
                end--;
            } else {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        return new String(arr);
    }
}
