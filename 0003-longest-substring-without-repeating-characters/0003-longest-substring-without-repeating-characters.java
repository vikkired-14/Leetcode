class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> cache = new HashMap<>();
        int left=0;int right =0;
        int maxLen=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(cache.containsKey(ch)){
                left = Math.max(left,cache.get(ch) +1);
            }
            maxLen = Math.max(right-left+1,maxLen);
            cache.put(ch,right++);
        }
        return maxLen;
    }
}