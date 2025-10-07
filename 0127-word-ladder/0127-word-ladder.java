class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Queue<String> qu = new LinkedList<String>();
        qu.offer(beginWord);
        int steps = 1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i=0;i<size;i++){
                String word = qu.poll();
                char[] charArr = word.toCharArray();
                for(int j=0;j<charArr.length;j++){
                  char ch = charArr[j];
                  for(char c='a';c<='z';c++){
                    if(c==ch) continue;
                    charArr[j] = c;
                    String newWord = new String(charArr);
                    if(endWord.equals(newWord))
                      return steps+1;
                    if(wordSet.contains(newWord)){
                        qu.offer(newWord);
                        wordSet.remove(newWord);
                    }  
                  }
                  charArr[j] = ch;
                }
            }
            steps++;
        }
        return 0;
    }
}