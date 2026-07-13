package StringsLearnin;

 class PowerOfTwo {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfTwo(int num) {
        if (num == 0) return false;

        while (num != 1) {
            if (num%2 != 0) {
                return false;
            } else {
                num/= 2;
            }
        }
        return true;
    }
}
