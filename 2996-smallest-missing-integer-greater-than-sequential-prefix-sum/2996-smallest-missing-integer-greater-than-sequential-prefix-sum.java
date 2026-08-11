class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        while(i < nums.length && nums[i] == nums[i - 1] + 1){
            sum = sum + nums[i];
            i = i + 1;
        }
        boolean found = true;
        while(found){
            found = false;
            for(int j = 0; j < nums.length; j++){
                if (nums[j] == sum) {
                    found = true;
                    sum = sum + 1;
                    break;
                }
            }
        }
        return sum;
    }
}