/**
 * @author WallfacerRZD
 * @date 2019/1/9 14:32
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
        }

        private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
            if (postEnd < 0 || inStart > inEnd) {
                return null;
            }
            int indexOfRootInInorder = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == postorder[postEnd]) {
                    indexOfRootInInorder = i;
                    break;
                }
            }
            TreeNode root = new TreeNode(postorder[postEnd]);
            int leftPostOrderIndex = postEnd - (inEnd - indexOfRootInInorder) - 1;
            int rightPostOrderIndex = postEnd - 1;
            root.left = helper(leftPostOrderIndex, inStart, indexOfRootInInorder - 1, inorder, postorder);
            root.right = helper(rightPostOrderIndex, indexOfRootInInorder + 1, inEnd, inorder, postorder);
            return root;
        }
    }
}
