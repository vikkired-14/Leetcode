class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        for(String str :tokens){
            if(!isOperator(str)){
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

     private boolean isOperator(String s) {
        return s.length() == 1 && "+-*/".contains(s);
    }
}