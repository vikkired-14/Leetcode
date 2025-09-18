class Solution {
    List<String>  res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(0,0,new StringBuilder(),n);
        return res;
    }

    public void  backtrack(int open,int close,StringBuilder path,int n){
        if(path.length() == 2*n){
            res.add(path.toString());
            return;
        }
        if(open<n){
         path.append('(');
         backtrack(open+1,close,path,n);
         path.deleteCharAt(path.length()-1);
        }
         
         if(open>close){
             path.append(')');
             backtrack(open,close+1,path,n);
             path.deleteCharAt(path.length()-1);
         }

    }
}