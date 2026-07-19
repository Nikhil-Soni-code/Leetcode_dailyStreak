class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch-'a']++;
        }

        HashSet<Character> set = new HashSet();
        Stack<Character> stack = new Stack();

        for(char ch : s.toCharArray()){

            count[ch-'a']--;   // CHANGE 1: decrement first

            if(set.contains(ch)) continue; // CHANGE 2

            while(!stack.isEmpty()
                    && stack.peek() > ch
                    && count[stack.peek()-'a'] >= 1){
                set.remove(stack.peek());
                stack.pop();
            }

            stack.push(ch);
            set.add(ch);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}