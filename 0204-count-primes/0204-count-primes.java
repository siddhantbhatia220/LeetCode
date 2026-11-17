class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            int subcount = 0;
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    subcount++;
                    break;
                }
            }
            if (subcount == 0)
                count++;
        }
        return count;
    }
}