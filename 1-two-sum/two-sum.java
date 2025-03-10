
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
























// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//      //Brute Force
//          int l,i,j;
//          l=nums.length;
//          for(i=0;i<l-1;i++){
//              for(j=i+1;j<l;j++){
//                  if(nums[i]+nums[j]==target){
//                          return new int[]{i,j};
//                  }
//              }
//          }
//         return new int[]{};
        

// //Optimal Solution
// //Only for case whn we ned to return the boolean expresion

//     // Arrays.sort(nums);
//     // int i=0,j=nums.length-1;
//     // while(i<j){
//     //     if(nums[i]+nums[j]==target){
//     //         return new int[]{i,j};
//     //     }
//     //     else if(nums[i]+nums[j]>target){
//     //         j--;
//     //     }
//     //     else{
//     //         i++;
//     //     }
//     // }
//     // return new int[]{0,0};



















//     }
// }