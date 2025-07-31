class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet();
        HashSet<Integer> curr = new HashSet();
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> temp = new HashSet();
            temp.add(arr[i]);
            for(Integer ele:curr){
                temp.add(arr[i]|ele);
            }
            curr = temp;
            result.addAll(curr);
        }
        return result.size();
    }
}