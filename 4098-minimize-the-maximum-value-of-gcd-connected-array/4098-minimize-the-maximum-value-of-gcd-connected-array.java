class Solution {
    public long minimumMaxValue(int n, int index, int value) {
        if (value == 1) return -1;
        int p = value;
        for (int i = 2; i <= value / i; i++) {
            if (value % i == 0) {
                p = i;
                break;
            }
        }
        if (value - p < 2L * index) return -1;
        if (index == n - 1) return value;
        return (long) value + p + 2L * (n - index - 2);
    }
}