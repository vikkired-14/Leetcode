class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> qu = new LinkedList<String>();
        qu.offer(beginWord);
        int count =1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int j=0;j<size;j++){
              String word = qu.poll();
              char[] charArr = word.toCharArray();
            for(int i=0;i<charArr.length;i++){
                char ch = charArr[i];
                for(char k = 'a';k<='z';k++){
                    charArr[i] = k;
                  String nextString = new String(charArr);
                  if(endWord.equals(nextString))
                    return count+1;
                  if(wordSet.contains(nextString)){
                    qu.offer(nextString);
                    wordSet.remove(nextString);
                  } 
                }
                charArr[i] = ch;
            }
            
            }
            count++;
            
        }
        return 0;
    }
}