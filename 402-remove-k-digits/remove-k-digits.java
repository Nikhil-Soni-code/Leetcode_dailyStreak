class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        Stack<Integer> stack = new Stack();
        for(int i=0;i<num.length();i++){
            int ele = num.charAt(i)-'0';
            while(!stack.isEmpty()&&k>0&&stack.peek()>ele){
                stack.pop();
                k--;
            }
            stack.push(ele);
        }
        StringBuilder sbr = new StringBuilder();

        while(!stack.empty()){
            sbr.insert(0,stack.pop());
        }
        String s = sbr.toString();
        if(k!=0){
            s = sbr.substring(0,sbr.length()-k);
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                return s.substring(i);
            }
        }
        return "0";
    }
}