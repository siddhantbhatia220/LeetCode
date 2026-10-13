class Solution {
    public long maxAlternatingSum(int[] nums) {
        long answer = 0 ;
        int len = nums.length ;
        for(int i=0 ; i<len ; i++)
            nums[i] = nums[i] * nums[i] ;
        Arrays.sort(nums) ;
        int left = 0 , right = nums.length-1 ;
        while(left < right)
        {
            answer += nums[right] ;
            answer -= nums[left] ;
            right-- ;
            left++ ;
        }
        if(len%2 == 1)  answer += nums[len/2] ;
        return answer ;
    }
}