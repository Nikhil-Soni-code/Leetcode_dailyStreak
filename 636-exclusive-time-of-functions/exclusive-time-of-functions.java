class Pair{
    int id;
    int timestamp;
    int childTime;
    public Pair(int id,int t,int c){
        this.id = id;
        this.timestamp = t;
        this.childTime = c;
    }
}
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Pair> stack = new Stack();
        for(String log:logs){
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int timestamp = Integer.parseInt(split[2]);
            if(type.equals("start")){
                stack.push(new Pair(id,timestamp,0));
            }else{
                Pair pair = stack.pop();
                int timeTaken = timestamp-pair.timestamp-pair.childTime+1;
                ans[pair.id] += timeTaken;
                if(!stack.isEmpty())
                {
                    Pair newPair = stack.pop();
                    newPair.childTime += pair.childTime+timeTaken;
                    stack.push(newPair);
                }
            }
        }
        return ans;
    }
}