class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> cache = new HashMap<>();
        int left=0;
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(cache.containsKey(ch)){
             maxLen = Math.max(maxLen,right-left);
             left = cache.get(ch)+1;
            }
            cache.put(ch,right);
        }

        return maxLen;
    }
}