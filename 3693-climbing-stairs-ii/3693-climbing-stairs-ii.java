class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0; 
        for (int cost : costs) {
            int cur = cost + Math.min(a + 1, Math.min(b + 4, c + 9));  
            c = b;
            b = a;
            a = cur;
        }
        return a;
    }
}