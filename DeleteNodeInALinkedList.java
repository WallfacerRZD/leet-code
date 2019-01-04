/**
 * @author WallfacerRZD
 * @date 2019/1/4 16:31
 */
public class DeleteNodeInALinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
