class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet();
        HashSet<Integer> prev = new HashSet(); 
        for(int i=0 ; i<arr.length ; i++){
            HashSet<Integer> curr = new HashSet();
            curr.add(arr[i]);
            for(Integer ele : prev){
                curr.add(ele|arr[i]);
            }
            prev = curr;
            result.addAll(curr);
        }
        return result.size();
    }
}