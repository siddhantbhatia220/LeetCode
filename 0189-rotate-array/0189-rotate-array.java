class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverseNums(nums, 0, n - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, n - 1);
    }
    private void reverseNums(int[] nums, int left, int right) {
        while ( left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}