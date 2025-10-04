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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        PriorityQueue<ListNode> pq = minHeap(lists);
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            node = node.next;
            tail = tail.next;
            if(node!=null){
                pq.offer(node);
            }
        }
     return head.next; 
    }

    public PriorityQueue<ListNode> minHeap(ListNode[] lists){
         PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
         });

         for(ListNode l: lists){
            if(l!=null)
             pq.offer(l);
         }
         return pq;
    }
}