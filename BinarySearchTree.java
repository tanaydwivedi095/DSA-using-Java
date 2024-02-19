import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchTree {
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinarySearchTreeFunctions{
        public TreeNode insert(TreeNode root, int val){
            if(root==null){
                root = new TreeNode(val);
                return root;
            }
            if(root.data>val){
                root.left = insert(root.left, val);
            }
            else{
                root.right = insert(root.right, val);
            }
            return root;
        }
        public void inorder(TreeNode root, ArrayList<Integer> array){
            if(root==null){
                return;
            }
            else{
                inorder(root.left, array);
                array.add(root.data);
                inorder(root.right, array);
            }
        }
        public void preorder(TreeNode root, ArrayList<Integer> array){
            if(root==null){
                return;
            }
            array.add(root.data);
            preorder(root.left, array);
            preorder(root.right, array);
        }
        public void postorder(TreeNode root, ArrayList<Integer> array){
            if(root==null){
                return;
            }
            postorder(root.left, array);
            postorder(root.right, array);
            array.add(root.data);
        }
        public boolean search(TreeNode root, int target){
            if(root==null){
                return false;
            }
            if(root.data==target){
                return true;
            }
            if(root.data>target){
                return search(root.left, target);
            }
            else{
                return search(root.right, target);
            }
        }
        public TreeNode findInorderSuccessor(TreeNode root){
            while(root.left!=null){
                root = root.left;
            }
            return root;
        }
        public TreeNode delete(TreeNode root, int val){
            if(root.data<val){
                root.right = delete(root.right, val);
            }
            else if(root.data>val){
                root.left = delete(root.left, val);
            }
            else{
                // NO CHILD
                if(root.left==null && root.right==null){
                    return null;
                }
                // ONE CHILD
                if(root.left==null){
                    return root.right;
                }
                else if(root.right==null){
                    return root.left;
                }
                // BOTH CHILDREN
                TreeNode IS = findInorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
            return root;
        }
        public void printInRange(TreeNode root, int k1, int k2){
            if(root==null){
                return;
            }
            else{
                if(root.data>=k1 && root.data<=k2) {
                    printInRange(root.left, k1, k2);
                    System.out.print(root.data + " ");
                    printInRange(root.right, k1, k2);
                }
                else if(k1>root.data){
                    printInRange(root.right, k1, k2);
                }
                else{
                    printInRange(root.left, k1, k2);
                }
            }
        }
        public void rootToLeafPaths(TreeNode root, ArrayList<Integer> path){
            if(root==null){
                return;
            }
            path.add(root.data);
            if(root.left==null && root.right==null){
                System.out.println(path);
                path.removeLast();
                return;
            }
            rootToLeafPaths(root.left, path);
            rootToLeafPaths(root.right, path);
            path.removeLast();
        }
        public boolean validateBST(TreeNode root){
            if(root==null){
                return true;
            }
            else if(root.left==null && root.right==null){
                return true;
            }
            else if(root.left!=null && root.right!=null) {
                if (root.left.data < root.data && root.right.data > root.data) {
                    return validateBST(root.left) && validateBST(root.right);
                } else {
                    return false;
                }
            }
            else if(root.left!=null){
                if(root.left.data < root.data){
                    return validateBST(root.left);
                }
                else{
                    return false;
                }
            }
            else{
                if(root.right.data>root.data){
                    return validateBST(root.right);
                }
                else{
                    return false;
                }
            }
        }
        public TreeNode mirrorBST(TreeNode root){
            if(root==null){
                return null;
            }
            TreeNode leftSubtree = mirrorBST(root.left);
            TreeNode rightSubtree = mirrorBST(root.right);
            root.left = rightSubtree;
            root.right = leftSubtree;
            return root;
        }
        public TreeNode sortedArrayToBalancedBST(ArrayList<Integer> array, int start, int end){
            if(start>end){
                return null;
            }
            int mid = (start+end)/2;
            TreeNode root = new TreeNode(array.get(mid));
            root.left = sortedArrayToBalancedBST(array, start, mid-1);
            root.right = sortedArrayToBalancedBST(array, mid+1, end);
            return root;
        }
        public TreeNode convertBSTToBalancedBST(TreeNode root){
            ArrayList<Integer> array = new ArrayList<>();
            inorder(root, array);
            TreeNode newRoot = sortedArrayToBalancedBST(array, 0, array.size()-1);
            return newRoot;
        }
    }
    public static void main(String args[]){
        int values[] = {8,5,3,6,10,11};
        BinarySearchTreeFunctions b1 = new BinarySearchTreeFunctions();
        TreeNode root = null;
        for(int i=0; i<values.length; i++){
            root = b1.insert(root, values[i]);
        }
        ArrayList<Integer> array = new ArrayList<>();
        b1.inorder(root, array);
        System.out.println(array);
        array = new ArrayList<>();
        b1.preorder(root, array);
        System.out.println(array);
        array = new ArrayList<>();
        b1.postorder(root, array);
        System.out.println(array);
        System.out.println(b1.search(root, 90));
        b1.delete(root, 5);
        array = new ArrayList<>();
        b1.inorder(root, array);
        System.out.println(array);
        b1.printInRange(root, 4, 124);
        System.out.println();
        b1.rootToLeafPaths(root, new ArrayList<>());
        System.out.println(b1.validateBST(root));
        array = new ArrayList<>();
        b1.mirrorBST(root);
        b1.inorder(root, array);
        System.out.println(array);
        int[] arr = {3,5,6,8,10,11,12};
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            arr2.add(arr[i]);
        }
        TreeNode root2 = b1.sortedArrayToBalancedBST(arr2, 0, arr2.size()-1);
        array = new ArrayList<>();
        b1.preorder(root2, array);
        System.out.println(array);
    }
}