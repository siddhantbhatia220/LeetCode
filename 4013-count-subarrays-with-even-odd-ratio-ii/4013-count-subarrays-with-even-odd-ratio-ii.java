import java.util.*;

class Solution {
    int[] bit;
    int m;

    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] f = new long[n + 1];
        int[] oddCnt = new int[n + 1];
        long even = 0, odd = 0;

        for (int k = 1; k <= n; k++) {
            if (nums[k - 1] % 2 == 0) even++; else odd++;
            oddCnt[k] = (int) odd;
            f[k] = (long) b * even - (long) a * odd;
        }

        long[] sortedF = f.clone();
        Arrays.sort(sortedF);
        m = 0;
        for (long v : sortedF) if (m == 0 || sortedF[m - 1] != v) sortedF[m++] = v;

        bit = new int[m + 1];
        int inserted = 0;
        long ans = 0;
        int prevOdd = -1;
        List<Integer> buffer = new ArrayList<>();

        for (int k = 0; k <= n; k++) {
            if (oddCnt[k] != prevOdd) {
                for (int idx : buffer) {
                    update(rank(sortedF, f[idx]) + 1);
                    inserted++;
                }
                buffer.clear();
                prevOdd = oddCnt[k];
            }
            int rk = rank(sortedF, f[k]);
            int lessCount = query(rk);
            ans += inserted - lessCount;
            buffer.add(k);
        }
        return ans;
    }

    private int rank(long[] sortedF, long val) {
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (sortedF[mid] < val) lo = mid + 1; else hi = mid;
        }
        return lo;
    }

    private void update(int i) { for (; i <= m; i += i & (-i)) bit[i]++; }
    private int query(int i) { int s = 0; for (; i > 0; i -= i & (-i)) s += bit[i]; return s; }
}