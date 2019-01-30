/**
 * reconstructBinaryTree using pre order and in order results.
 */

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0|| in.length == 0){
            return null;
        }
        int inStart = 0;
        int inEnd = in.length - 1;
        int preStart = 0;
        int preEnd = pre.length - 1;
        return constructCore(pre, in, preStart, preEnd, inStart, inEnd);
    }
    private TreeNode constructCore(int[] pre, int[] in, int preStart, int preEnd,
                                   int inStart, int inEnd){
        if (preStart > preEnd ){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        int inRoot = 0;
        for(int i = 0; i < in.length; i++){
            if (in[i] == pre[preStart]){
                inRoot = i;
            }
        }

        if (in[inRoot] != pre[preStart]){
            System.out.println("wrong input!!!");
            return null;
        }

        int lCount = inRoot - inStart;
        int rCount = inEnd - inRoot;

        // for left sub-tree
        int lPreStart = preStart + 1;
        int lPreEnd = preStart + lCount;
        if (lCount > 0){
            root.left = constructCore(pre, in, lPreStart, lPreEnd,
                    inStart, inRoot -1);
        }

        // for right sub-tree
        int rPreStart = preStart + lCount + 1;
        if (rCount > 0){
            root.right = constructCore(pre, in, rPreStart, preEnd,
                    inRoot + 1, inEnd);
        }

        return root;
    }

    public static void main(String[] args) {
        ReConstructBinaryTree r = new ReConstructBinaryTree();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = r.reConstructBinaryTree(pre, in);
        System.out.println(root.val);
    }
}