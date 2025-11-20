class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited = new boolean[26];
        int[] lastOccur = new int[26];
        for(int i=0;i<s.length();i++){
            lastOccur[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!visited[ch-'a']){
                while(!stack.isEmpty() && stack.peek()>=ch && lastOccur[stack.peek()-'a']>=i){
                    visited[stack.pop()-'a'] = false;
                }
                stack.push(ch);
                visited[ch-'a'] = true;
            }
        }
        StringBuilder sbr = new StringBuilder();
        while(!stack.isEmpty()){
            sbr.insert(0,stack.pop());
        }return sbr.toString();

    }
}