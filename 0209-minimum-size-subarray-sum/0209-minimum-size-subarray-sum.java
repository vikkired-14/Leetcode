class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0;
        int prefixSum =0;
        int minLen = nums.length+1;
        while(right<nums.length){
            prefixSum += nums[right];
            while(prefixSum>=target){
                minLen = Math.min(minLen,right-left+1);
                prefixSum -= nums[left++];
            }
            right++;
        }
       return minLen == nums.length+1 ? 0: minLen;
    }
}