class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int left =0;
       Map<Integer,Integer> cache = new HashMap<>();
       long sum =0;
       long maxSum = 0;
      for(int right=0;right<nums.length;right++){
        while(cache.containsKey(nums[right])){
            sum -= nums[left];
            cache.remove(nums[left++]);
        }
        cache.put(nums[right],right);
        if(cache.size()>k){
             sum -= nums[left];
            cache.remove(nums[left++]);
        }
         sum += nums[right];
         
         if(cache.size()==k){
           maxSum = Math.max(maxSum,sum);
         }
          
        
         
      } 

      return maxSum;
    }
}