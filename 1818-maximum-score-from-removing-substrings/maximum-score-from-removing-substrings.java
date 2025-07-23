class Solution {
    int score = 0;
    private String removeba(String s,int y){
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'&&!stack.empty()&&stack.peek()=='b'){
                score+=y;
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sbr = new StringBuilder();
        while(!stack.empty()){
            sbr.insert(0,stack.pop());
        }
        s = sbr.toString();
        return s;
    }
    private String removeab(String s,int x){
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'&&!stack.empty()&&stack.peek()=='a'){
                score+=x;
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sbr = new StringBuilder();

        while(!stack.empty()){
            sbr.insert(0,stack.pop());
        }
        s = sbr.toString();
        return s;

    }
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            s = removeab(s,x);
            removeba(s,y);
        }
        else{
            s = removeba(s,y);
            removeab(s,x);
        }
        return score;
    }
}