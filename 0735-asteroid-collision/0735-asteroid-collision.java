class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int ast:asteroids ){
            boolean alive = true;
            while(alive && ast<0 &&!st.isEmpty() && st.peek()>0){
                if(st.peek()< -ast){
                    st.pop();
                    continue;
                }else if(st.peek()== -ast) {
                    st.pop();
                }
                alive= false;
            }
            if(alive)
              st.push(ast);
        }
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}