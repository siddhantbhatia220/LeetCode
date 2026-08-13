class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
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