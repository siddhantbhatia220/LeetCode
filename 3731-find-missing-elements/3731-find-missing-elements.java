class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0], max = nums[0];
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            min = Math.min(min, x);
            max = Math.max(max, x);
            set.add(x);
        }
        List<Integer> ans = new ArrayList<>();
        for(int x = min + 1; x < max; x++){
            if(!set.contains(x)) ans.add(x);
        }
        return ans;
    }
}