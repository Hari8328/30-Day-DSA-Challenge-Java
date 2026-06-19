import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BalancedBinaryTree {

    public static boolean isBalanced(
            TreeNode root) {

        return height(root) != -1;
    }

    private static int height(
            TreeNode node) {

        if (node == null)
            return 0;

        int left =
                height(node.left);

        int right =
                height(node.right);

        if (left == -1 ||
                right == -1) {

            return -1;
        }

        if (Math.abs(
                left - right) > 1) {

            return -1;
        }

        return Math.max(
                left,
                right
        ) + 1;
    }

    public static void main(String[] args) {

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(20);

        root.right.left =
                new TreeNode(15);

        root.right.right =
                new TreeNode(7);

        System.out.println(
                isBalanced(root)
        );
    }
}
