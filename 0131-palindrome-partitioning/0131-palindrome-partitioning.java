class Solution {
     List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backTrack(s,0,new ArrayList<>());
        return res;
    }

    public void backTrack(String s,int idx,List<String> path){
        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end = idx;end<s.length();end++){
             if (isPalindrome(s, idx, end)) {
                path.add(s.substring(idx, end + 1));
                backTrack(s,end+1,path);
                path.remove(path.size() - 1);
             }
        }
        
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}