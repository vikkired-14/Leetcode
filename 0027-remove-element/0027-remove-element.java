class Solution {
    public int removeElement(int[] nums, int val) {
        int writer = 0;
        for(int reader =0;reader<nums.length;reader++){
            if(nums[reader]!=val){
               nums[writer++] = nums[reader]; 
            }
        }
        return writer;
    }
}