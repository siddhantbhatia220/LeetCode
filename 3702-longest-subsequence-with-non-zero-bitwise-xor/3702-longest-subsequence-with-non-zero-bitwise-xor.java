class Solution {
    public int longestSubsequence(int[] nums) {
        int xorAll = 0;
        boolean hasNonZero = false;
        for (int x : nums) {
            xorAll ^= x;
            if (x != 0) hasNonZero = true;
        }
        if (xorAll != 0) return nums.length;
        if (hasNonZero) return nums.length - 1;
        return 0;
    }
}