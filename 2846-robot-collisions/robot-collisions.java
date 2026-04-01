class Pair{
    int position;
    char direction;
    int health;
    public Pair(int p,int h,char d){
        position = p;
        direction = d;
        health = h;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList();
        List<Pair> list = new ArrayList();
        for(int i=0 ; i<positions.length ; i++){
            list.add(new Pair(positions[i],healths[i],directions.charAt(i)));
        }
        Collections.sort(list,(a,b)->a.position-b.position);
        Stack<Pair> stack = new Stack();
        for(int i=0 ; i<list.size() ; i++){
            if(stack.isEmpty() || stack.peek().direction == list.get(i).direction || stack.peek().direction == 'L'){
                stack.push(list.get(i));
            }else{
                Pair curr = list.get(i);
                boolean push = false;
                while(!stack.isEmpty() && stack.peek().direction == 'R' && curr.direction == 'L'){
                    if(stack.peek().health == curr.health){
                        stack.pop();
                        push = false;
                        break;
                    }else if(stack.peek().health > curr.health){
                        stack.peek().health --;
                        push = false;
                        break;
                    }else{
                        stack.pop();
                        curr.health --;
                        push = true;
                    }
                }
                if(push)stack.push(curr);
            }
        }
        HashMap<Integer,Integer> map = new HashMap();
        while(!stack.isEmpty()){
            Pair poped = stack.pop();
            map.put(poped.position,poped.health);
        }
        for(int i=0 ; i<positions.length ; i++){
            if(map.containsKey(positions[i]))ans.add(map.get(positions[i]));
        }
        return ans;
    }
}