class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int f = s.length(); f >= 1; f--) {
            for (int ch = 0; ch < 128; ch++) {
                if (freq[ch] == f) {
                    for (int k = 0; k < f; k++) {
                        sb.append((char) ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}