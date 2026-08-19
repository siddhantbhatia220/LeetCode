class Solution {
    public boolean canJump(int[] nums) {
        int gas = 0;
        for (int n : nums) {
            if (gas < 0) {
                return false;
            } else if (n > gas) {
                gas = n;
            }
            gas -= 1;
        }
        return true;
    }
}