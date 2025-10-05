class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int time = 0;
        for(char ch: tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int f : freq) {
            if(f > 0) pq.offer(f);
        }

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
            while(cycle>0 && !pq.isEmpty()){
                int curr = pq.poll();
                if(curr-1>0) {
                    temp.add(curr-1);
                }
                time++;
                cycle--;
            }
            for(int tsk: temp){
                pq.offer(tsk);
            }
            if(!pq.isEmpty()){
                time += cycle;
            }
        }
        return time;
    }

    /*
    class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }
        
        // find max frequency
        int maxFreq = 0;
        for(int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        
        // count how many tasks have this max frequency
        int countMax = 0;
        for(int f : freq) {
            if(f == maxFreq) countMax++;
        }
        
        // formula
        int partCount = (maxFreq - 1) * (n + 1) + countMax;
        
        // answer is the max of partCount and total tasks
        return Math.max(tasks.length, partCount);
    }
}

    */
}