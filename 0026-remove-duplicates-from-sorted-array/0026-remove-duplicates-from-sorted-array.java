class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int right=1;right<nums.length;right++){
            if(nums[left]==nums[right])
             continue;
            nums[left++ +1] = nums[right];
        }
        return left+1;
    }
}