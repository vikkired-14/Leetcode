class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        for(String str :tokens){
            if(isInteger(str)){
                st.push(Integer.parseInt(str));
            }else{
                int a = st.pop();
                int b = st.pop();
                int k = switch(str){
                    case "+" -> b+a ;
                    case "-" -> b-a ;
                    case "*" -> b*a ;
                    case "/" -> b/a ;
                     default -> throw new IllegalArgumentException("Invalid operator: " + str);

                };
                st.push(k);
            }
        }
        return st.pop();
    }

    public boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}