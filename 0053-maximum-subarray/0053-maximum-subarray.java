class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1)
         return nums[0];
        int maxSum =nums[0];
        int max =nums[0];
        for(int i=1;i<nums.length;i++){
            max = Math.max(nums[i],nums[i]+max);
            maxSum = Math.max(maxSum,max);
        } 
        return maxSum;
    }
}