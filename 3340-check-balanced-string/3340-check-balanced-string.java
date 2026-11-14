class Solution {
    public boolean isBalanced(String num) {
        int count = 0;
        boolean bit = true;
        for (char c : num.toCharArray()) {
            if (bit)
                count += (c - '0');
            else
                count -= (c - '0');
            bit = !bit;
        }
        return count == 0;
    }
}