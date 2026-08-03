class Solution {
    public long maxPairStrength(int[] nums) {
        long best = Long.MIN_VALUE;

        // check every pair (i, j)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                
                long a = nums[i];
                long b = nums[j];

                // find gcd using simple while loop
                long x = a, y = b;
                while (y != 0) {
                    long temp = y;
                    y = x % y;
                    x = temp;
                }
                long g = x;  // this is the gcd

                long strength = (a * b) / (g * g);

                if (strength > best) {
                    best = strength;
                }
            }
        }

        return best;
    }
}