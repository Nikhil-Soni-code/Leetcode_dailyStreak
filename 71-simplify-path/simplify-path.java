class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        int i=0;
        while(i<path.length()){
            if(path.charAt(i)=='/'){
                StringBuilder sbr = new StringBuilder("/");
                i++;
                while(i<path.length()&&path.charAt(i)!='/'){
                    sbr.append(path.charAt(i++));
                }
                if(sbr.toString().equals("/..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }

                }
                else if(!sbr.toString().equals("/.")&&!sbr.toString().equals("/")){
                    stack.push(sbr.toString());
                }
            }
        }
        while(!stack.isEmpty()&&stack.peek()=="/"){
            stack.pop();
        }
        StringBuilder sbr = new StringBuilder();

        while(!stack.isEmpty()){
            sbr.insert(0,stack.pop());
        }
        
        if(sbr.length()==0)return "/";
        return sbr.toString();

    }
}