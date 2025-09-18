class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Boolean> map = new HashMap();
        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i),true);
        }
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                String word = queue.poll();
                if(word.equals(endWord))return count;
                char[] charArray = word.toCharArray();

                for(int i=0;i<charArray.length;i++){
                    char temp = charArray[i];
                    for(char alpha = 'a' ; alpha<='z' ; alpha++){
                        charArray[i] = alpha;
                        String newWord = new String(charArray);
                        if(map.containsKey(newWord)&&map.get(newWord)){
                            queue.add(newWord);
                            map.put(newWord,false);
                        }
                    }
                    charArray[i] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}