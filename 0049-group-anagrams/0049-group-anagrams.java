class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> cache = new HashMap<>();
       
       
        for(String s: strs){
             int[] arr = new int[26];
              StringBuilder sb = new StringBuilder();
            for(char ch: s.toCharArray()){
               arr[ch-'a']++;
            }
            for(int i=0;i<26;i++){
           sb.append(arr[i]).append('#');
        }
        String key = sb.toString();
        List<String> res = cache.getOrDefault(key,new ArrayList<>());
        res.add(s);
         cache.put(key,res);
        }
        
        return new ArrayList<>(cache.values());
    }
}