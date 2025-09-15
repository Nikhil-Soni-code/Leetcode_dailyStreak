class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet();
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        int count = 0;
        for(String word:text.split(" ")){
            boolean flag = true;
            for(int i=0;i<word.length();i++){
                if(set.contains(word.charAt(i))){
                    flag = false;
                    break;
                }
            }
            if(flag)count++;
        }
        return count;
    }
}