class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for (int  i = 0; i < nums.size(); i++) {
            Set<Integer> k = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                k.add(nums.get(j));
                ans += (k.size() * k.size());
            } 
        }
        return ans;
    }
}