class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        k=k%len;
        if(k%len == 0) return head;
        int n = len - k ;
        int i = 1;
        temp = head;
        while(i<n){
            temp = temp.next;
            i++;
        }
        ListNode head2 = temp.next;
        temp.next= null;
        // linking the 2nd head to 1st head
        temp = head2;
        while(temp.next!=null) temp = temp.next;
        temp.next = head;
        return head2;

    }
}