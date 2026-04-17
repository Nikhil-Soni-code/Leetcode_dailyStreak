class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet();
        for(char ch : word.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for(char ch : word.toCharArray()){
            if(set.contains(ch)){if(ch >= 97){
                if(set.contains(Character.toUpperCase(ch))){
                    count++;
                    set.remove(ch);
                    set.remove(Character.toLowerCase(ch));
                }
            }else{
                if(set.contains(Character.toLowerCase(ch))){
                    count++;
                    set.remove(ch);
                    set.remove(Character.toLowerCase(ch));
                }
            }}
        }return count;
    }
}