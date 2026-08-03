class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long maxStrength = Long.MIN_VALUE; 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long g = gcd(nums[i], nums[j]);
                long product = (long) nums[i] * (long) nums[j];
                long strength = product / (g * g);
                maxStrength = Math.max(maxStrength, strength);
            }
        }
        return maxStrength;
    }
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}