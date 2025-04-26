class Solution {
    private int findLength(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = findLength(head);
        if(head == null || head.next == null || length < k) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        int i = 1;

        while(i < k){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
            i++;
        }
        curr.next = prev; // Reverse the last node of the group also

        // Now head has become the last node of the reversed group
        head.next = reverseKGroup(next, k);

        return curr; // Return new head (which is original kth node)
    }
}
