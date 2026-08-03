import java.util.Arrays;

class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++) p[i + 1] = p[i] + tasks[i];
        long pos = 0;
        int[] ans = new int[shifts.length];
        for (int j = 0; j < shifts.length; j++) {
            long rem = p[n] - pos;
            if (shifts[j] >= rem) { pos = 0; continue; }  
            pos += shifts[j];
            int idx = Arrays.binarySearch(p, pos);
            int done = idx >= 0 ? idx : -idx - 2;
            ans[j] = n - done;
        }
        return ans;
    }
}