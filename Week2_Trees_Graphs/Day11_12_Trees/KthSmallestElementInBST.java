import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class KthSmallestElementInBST {

    private static int count = 0;
    private static int answer = 0;

    public static int kthSmallest(
            TreeNode root,
            int k) {

        count = 0;
        answer = 0;

        inorder(root, k);

        return answer;
    }

    private static void inorder(
            TreeNode node,
            int k) {

        if (node == null)
            return;

        inorder(node.left, k);

        count++;

        if (count == k) {

            answer = node.val;
            return;
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {

        TreeNode root =
                new TreeNode(3);

        root.left =
                new TreeNode(1);

        root.left.right =
                new TreeNode(2);

        root.right =
                new TreeNode(4);

        System.out.println(
                kthSmallest(root, 1)
        );

        System.out.println(
                kthSmallest(root, 3)
        );
    }
}
