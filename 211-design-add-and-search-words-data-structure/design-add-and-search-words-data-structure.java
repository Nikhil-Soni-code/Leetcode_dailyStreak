class WordDictionary {
    HashSet<String> set;
    public WordDictionary() {
        set = new HashSet();
    }
    
    public void addWord(String word) {
        set.add(word);
    }
    
    public boolean search(String word) {
        if(set.contains(word))return true;
        if(word.indexOf('.') !=-1){
            char[] letters = word.toCharArray();
            int idx1 = -1;
            int idx2 = -1;
            for(int i=0 ; i<letters.length ; i++){
                if(letters[i]== '.'){
                    if(idx1==-1){
                        idx1 = i;
                    }else{
                        idx2 = i;
                    }
                }
            }
            for(char i='a' ; i<='z' ; i++){
                for(char j='a' ; j<='z' ; j++){
                    letters[idx1] = i;
                    if(idx2!=-1)letters[idx2] = j;
                    if(set.contains(new String(letters)))return true;
                }
            }return false;
        }else{
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */