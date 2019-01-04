/**
 * @author WallfacerRZD
 * @date 2019/1/4 16:19
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int x) {
            this.val = x;
        }
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                boolean inSameSide = (root.val - p.val ) * (root.val - q.val ) > 0;
                if (!inSameSide) {
                    break;
                }
                root = p.val > root.val ? root.right : root.left;
            }
            return root;
        }
    }

    static class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            boolean inSameSide = (root.val - p.val ) * (root.val - q.val ) > 0;
            if (inSameSide) {
                return lowestCommonAncestor(root.val > p.val ? root.left : root.right, p, q);
            } else {
                return root;
            }
        }
    }
}
