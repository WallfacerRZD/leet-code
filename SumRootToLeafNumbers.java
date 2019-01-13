/**
 * @author WallfacerRZD
 * @date 2019/1/13 17:34
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeafNumbers {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    class Solution {
        private int result = 0;
        public int sumNumbers(TreeNode root) {
            helper(root, 0);
            return result;
        }

        private void helper(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            boolean isLeafNode = root.left == null && root.right == null;
            if (isLeafNode) {
                result += sum * 10 + root.val;
                return;
            }
            helper(root.left, sum * 10 + root.val);
            helper(root.right, sum * 10 + root.val);
        }
    }
}
