import java.util.ArrayList;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2019/1/10 13:47
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class PathSumII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            helper(result, new ArrayList<>(), root, sum);
            return result;
        }

        private void helper(List<List<Integer>> result, List<Integer> path, TreeNode node, int remain) {
            if (node == null) {
                return;
            }
            path.add(node.val);
            boolean isLeafNode = node.left == null && node.right == null;
            if (isLeafNode && remain == node.val) {
                result.add(new ArrayList<>(path));
            }
            helper(result, path, node.left, remain - node.val);
            helper(result, path, node.right, remain - node.val);
            path.remove(path.size() - 1);
        }
    }
}
