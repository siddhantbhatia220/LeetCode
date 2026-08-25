class Solution {
    public boolean canAliceWin(int[] nums) {
         int singledigit = 0;
        int doubledigit = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= 9){
                singledigit += nums[i];
            }else{
                doubledigit += nums[i];
            }
        }
        if(singledigit < doubledigit || singledigit > doubledigit){
            return true;
        }
        else{
            return false;
        }
    }
}