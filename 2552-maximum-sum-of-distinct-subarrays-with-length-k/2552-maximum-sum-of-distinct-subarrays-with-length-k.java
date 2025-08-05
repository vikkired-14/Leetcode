class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       Map<Integer,Integer> cache = new HashMap<>();
       int left=0;
       long sum=0;
       long maxSum =0;
       for(int right=0;right<nums.length;right++){
          cache.put(nums[right],cache.getOrDefault(nums[right],0)+1);
          sum += nums[right];
          while(right-left+1>k || cache.get(nums[right])>1){
            cache.put(nums[left],cache.get(nums[left])-1); 
            if(cache.get(nums[left])==0)
              cache.remove(nums[left]);  
            sum -= nums[left];
            left++;  
          }
          if(right-left+1==k){
            maxSum = Math.max(maxSum,sum);
          }
       } 
       return maxSum;
    }
}