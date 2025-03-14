class Solution {
    public String decodeString(String s) {
        Stack<String>stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=']'){
                stack.push(String.valueOf(s.charAt(i)));
            }
            else{
                StringBuilder sbr = new StringBuilder();
                while(!stack.peek().equals("[")){
                    sbr.insert(0,stack.pop());
                }
                stack.pop();
                StringBuilder repeat = new StringBuilder();
                while(!stack.empty()&&Character.isDigit(stack.peek().charAt(0))){
                    repeat.insert(0,stack.pop());
                }
                int repeated = Integer.parseInt(repeat.toString());
                StringBuilder subAns = new StringBuilder();
                for(int j=0;j<repeated;j++){
                    subAns.append(sbr);
                }
                stack.push(subAns.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }return ans.toString();
    }
}