import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author WallfacerRZD
 * @date 2019/1/7 15:56
 */

public class UniqueBinarySearchTreesII {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }

    }

    /**
     * TODO
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> result = new ArrayList<>();
            LinkedList<Integer> integers = new LinkedList<>();
            IntStream.range(1, n + 1).forEach(integers::addLast);
            helper(result, null, null, 1, integers, n, 0);
            return result;
        }

        private void helper(List<TreeNode> result, TreeNode root, TreeNode tempRoot,
                            int currentValue, LinkedList<Integer> integers, int n, int count) {
            if (count > n) {
                return;
            }
            if (count == n) {
                result.add(root);
                return;
            }
            TreeNode treeNode = new TreeNode(currentValue);
            while (!integers.isEmpty()) {

            }

        }
    }
}
