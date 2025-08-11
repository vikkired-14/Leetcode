class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preFixSum = new HashMap<>();
        preFixSum.put(0,1);
        int sum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(preFixSum.containsKey(sum-k)){
                count += preFixSum.get(sum-k);
            }
            preFixSum.put(sum,preFixSum.getOrDefault(sum,0)+1);
        }
        return count;
}
}