class Solution {
    List<String> res;
    Map<Character,String> digitMap;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        res = new ArrayList<>();
        digitMap = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno"
        ,'7',"pqrs",'8',"tuv",'9',"wxyz");
        backTrack(digits,0,new StringBuilder());
        return res;
    }

    public void  backTrack(String digits,int idx,StringBuilder path){
        if(path.length()==digits.length()){
            res.add(path.toString());
            return;
        }
        char c = digits.charAt(idx);
        for(char ch: digitMap.get(c).toCharArray()){
             path.append(ch);
             backTrack(digits,idx+1,path);
             path.deleteCharAt(path.length()-1);
        }

    }
}