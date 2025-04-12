class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++){
            if(map.containsKey(hand[i])){
                int ele = hand[i];
                for(int j=ele;j<ele+groupSize;j++){
                    if(map.containsKey(j)){
                        map.put(j,map.get(j)-1);
                        if(map.get(j)==0)map.remove(j);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}