class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int ast:asteroids ){
            boolean alive = true;
            while(alive && ast<0 && !stack.isEmpty() && stack.peek()>0){
                if(stack.peek()<-ast){
                    stack.pop();
                    continue;
                }else if(stack.peek()==-ast){
                     stack.pop();
                }
                 alive = false;
            }
            if(alive)
              stack.push(ast);
        }

        int n = stack.size();
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
           res[i] = stack.pop();
        }
        return res;
    }
}