class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            int ch = nums[i];
            if (ch < min) return true;
            while(!st.isEmpty() && st.peek() < ch){
                min = st.pop();
            }
            st.push(ch);
        }
        return false;
    }
}