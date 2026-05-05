
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int count = 0;

        while(temp != null){
            if(set.contains(temp.val)){
                while(temp != null && set.contains(temp.val) ){
                    temp = temp.next;
                }
                count++;
            }
            else{
                temp = temp.next;
            } 
            
        }
        return count;
    }
}