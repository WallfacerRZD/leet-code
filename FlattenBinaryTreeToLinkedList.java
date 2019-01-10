/**
 * @author WallfacerRZD
 * @date 2019/1/10 14:07
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 写递归最好的方法就是想当然
     */
    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;

            flatten(left);
            flatten(right);

            root.right = left;
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right;
        }
    }
}
