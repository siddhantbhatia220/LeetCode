class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() < nums[i]){
                max = st.pop();
            }
            if(nums[i] > max) st.push(nums[i]);
            if(nums[i] < max) return true;
        }
        return false;
    }
}