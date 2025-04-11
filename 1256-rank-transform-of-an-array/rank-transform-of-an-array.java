class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[]copyArray = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            copyArray[i] = arr[i];
        }
        HashMap<Integer,Integer> map = new HashMap();
        Arrays.sort(copyArray);
        int pos = 0;
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(copyArray[i])){
                pos++;
                map.put(copyArray[i],pos);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }return arr;
    }
}