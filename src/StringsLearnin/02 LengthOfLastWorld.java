package StringsLearnin;

 class LengthOfLastWorld {
    public static void main(String[] args) {
        String str = " fly to the world  ";
        System.out.println(getLengthOfLastWorld(str));
    }

    public static int getLengthOfLastWorld(String s) {
        String str = s.trim();
        int count = 0;
        for (int i = str.length() -1 ; i > 0; i--) {
            if (str.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
