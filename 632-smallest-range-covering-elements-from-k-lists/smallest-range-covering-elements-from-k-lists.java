class Pair{
    int value;
    int i;
    int j;
    public Pair(int value,int i,int j){
        this.value = value;
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] result = {-100000,100000};
        PriorityQueue<Pair> minPq = new PriorityQueue<>((a,b)-> a.value-b.value);
        int maxElement = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            minPq.add(new Pair(nums.get(i).get(0),i,0));
            maxElement = Math.max(maxElement,nums.get(i).get(0));
        }
        while(true){
            Pair minPair = minPq.poll();
            int minElement = minPair.value;
            if((result[1]-result[0])>=(maxElement-minElement)){
                if((result[1]-result[0])==(maxElement-minElement)){
                    if(result[0]>minElement){
                        result[0] = minElement;
                        result[1] = maxElement;
                    }
                }else{
                        result[0] = minElement;
                        result[1] = maxElement;
                }
            }
            int i = minPair.i;
            int j = minPair.j;
            if(j<nums.get(i).size()-1){
                int newElement = nums.get(i).get(j+1);
                maxElement = Math.max(maxElement,newElement);
                minPq.add(    new Pair(newElement,i,j+1)    );

            }else{
                break;
            }
        }
        return result;

    }
}