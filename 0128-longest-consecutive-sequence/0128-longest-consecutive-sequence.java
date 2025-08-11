class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> seen = new HashMap<>();
        int maxLen =0;
        for(int n: nums){
            if(!seen.containsKey(n)){
                int left = seen.getOrDefault(n-1,0);
                int right = seen.getOrDefault(n+1,0);
                int length = left+right+1;
                seen.put(n-left,length);
                seen.put(n+right,length);
                seen.put(n,length);
                maxLen = Math.max(maxLen,length);
            }
        }
        return maxLen;
    }
}