class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && heights[s1.peek()] >= heights[i]) s1.pop();
            left[i] = s1.isEmpty() ? -1 : s1.peek();
            s1.push(i);
            int j = n - 1 - i;
            while (!s2.isEmpty() && heights[s2.peek()] >= heights[j]) s2.pop();
            right[j] = s2.isEmpty() ? n : s2.peek();
            s2.push(j);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
}