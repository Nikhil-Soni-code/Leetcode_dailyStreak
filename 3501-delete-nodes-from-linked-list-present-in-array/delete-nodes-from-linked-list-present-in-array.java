/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while(head!=null){
            if(!set.contains(head.val)){
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        temp.next = null;
        return dummyHead.next;
    }
}