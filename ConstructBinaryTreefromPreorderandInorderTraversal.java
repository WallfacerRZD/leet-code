/**
 * @author WallfacerRZD
 * @date 2019/1/9 13:56
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            if (preStart >= preorder.length || inStart > inEnd) {
                return null;
            }
            int indexOfRootInInorder = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == preorder[preStart]) {
                    indexOfRootInInorder = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = helper(preStart + 1, inStart, indexOfRootInInorder - 1, preorder, inorder);
            root.right = helper(preStart + indexOfRootInInorder - inStart + 1, indexOfRootInInorder + 1, inEnd, preorder, inorder);
            return root;
        }
    }
}
