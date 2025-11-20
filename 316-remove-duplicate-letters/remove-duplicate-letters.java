class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] taken = new boolean[26];
        int[] lastPosition = new int[26];
        for(int i=0;i<s.length();i++){
            lastPosition[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!taken[ch-'a']){
                while(!stack.isEmpty() && stack.peek()>=ch && lastPosition[stack.peek()-'a']>=i){
                    taken[stack.pop()-'a'] = false;
                }
                stack.push(ch);
                taken[ch-'a'] = true;
            }
        }
        StringBuilder sbr = new StringBuilder();
        while(!stack.isEmpty()){
            sbr.insert(0,stack.pop());
        }return sbr.toString();
        
    }
}