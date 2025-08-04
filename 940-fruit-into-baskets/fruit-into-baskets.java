class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length<=1){
            return 1;
        }
        HashMap<Integer,Integer> map=new HashMap();
        int start=0,end=0;
        int maxLength=Integer.MIN_VALUE;
        while(end<fruits.length){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(start<end&&map.size()>2){
                if(maxLength<end-start){
                    maxLength=end-start;
                }
                map.put(fruits[start],map.getOrDefault(fruits[start],0)-1);
                if(map.get(fruits[start])==0){
                    map.remove(fruits[start]);
                }
                start++;
            }
            end++;
        }
        if(map.size()<=2&&maxLength<end-start){
                    maxLength=end-start;

        }
        return maxLength;
    }
}