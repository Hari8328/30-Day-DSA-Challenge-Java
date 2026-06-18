import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInorderTraversal {

    public static void inorder(TreeNode root,
                               List<Integer> result) {

        if (root == null)
            return;

        inorder(root.left, result);

        result.add(root.val);

        inorder(root.right, result);
    }

    public static List<Integer> inorderTraversal(
            TreeNode root) {

        List<Integer> result =
                new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public static void main(String[] args) {

        TreeNode root =
                new TreeNode(1);

        root.right =
                new TreeNode(2);

        root.right.left =
                new TreeNode(3);

        System.out.println(
                inorderTraversal(root)
        );
    }
}
