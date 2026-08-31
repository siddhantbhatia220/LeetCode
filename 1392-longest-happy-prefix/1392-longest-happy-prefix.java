class Solution {
    public String longestPrefix(String s) {
       int n = s.length();
        int[] lps = new int[n];
        int j = 0; 
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }
}