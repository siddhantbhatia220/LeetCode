class Solution {
    public int smallestNumber(int n, int t) {
        int res = n;
        while (true) {
            int product = 1;
            int cur = res;
            while (cur > 0) {
                product *= (cur % 10);
                cur /= 10;
            }
            if (product % t == 0) {
                return res;
            }
            res++;
        }
    }
}