package StringLearningFromSharma;

 class SumOfAllBeauty {
    public static void main(String[] args) {

        String str = "aabcb";
        int beautySum = getSumOfBeauty(str);
        System.out.println(beautySum);
    }

    private static int getMinCount(int[] freq) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                minCount = Math.min(minCount, freq[i]);
            }
        }
        return minCount;
    }

    private static int getMaxCount(int[] freq) {
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }

    public static int getSumOfBeauty(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < str.length(); j++) {
                freq[str.charAt(j) - 'a']++;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum+= beauty;
            }
        }
        return sum;
    }
}
