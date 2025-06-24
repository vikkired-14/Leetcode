class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int ele = target - nums[i];
            if(seen.containsKey(ele)){
                return new int[]{seen.get(ele),i};
            }
            seen.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}