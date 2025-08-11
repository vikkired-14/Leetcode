class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> seen = new HashMap<>();
        int maxLen =0;
        for(int n: nums){
            if(!seen.containsKey(n)){
                int left = seen.getOrDefault(n-1,0);
                int right = seen.getOrDefault(n+1,0);
                int len = left + right + 1;
                seen.put(n-left,len);
                seen.put(n+right,len);
                seen.put(n,len);
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}