package StringsLearnin;

 class RansomNotes {
    public static void main(String[] args) {

    }

    public static boolean isRansom(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch: ransomNote.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }
        return true;
    }

}
