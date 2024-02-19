import java.util.*;
import java.util.LinkedList;

public class BinaryTrees {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree{
        int idx = -1;
        public Node buildTreeFromPreOrder(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTreeFromPreOrder(nodes);
            newNode.right = buildTreeFromPreOrder(nodes);
            return newNode;
        }
        public ArrayList<Integer> preOrderTraversal(Node root, ArrayList<Integer> result){
            if(root==null){
                result.add(-1);
                return result;
            }
            result.add(root.data);
            preOrderTraversal(root.left, result);
            preOrderTraversal(root.right, result);
            return result;
        }
        public ArrayList<Integer> postOrderTraversal(Node root, ArrayList<Integer> result){
            if(root==null){
                result.add(-1);
                return result;
            }
            postOrderTraversal(root.left, result);
            postOrderTraversal(root.right, result);
            result.add(root.data);
            return result;
        }
        public ArrayList<Integer> inOrderTraversal(Node root, ArrayList<Integer> result){
            if(root==null){
                result.add(-1);
                return result;
            }
            inOrderTraversal(root.left, result);
            result.add(root.data);
            inOrderTraversal(root.right, result);
            return result;
        }
        public ArrayList<Integer> levelOrderTraversal(Node root){
            ArrayList<Integer> result = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node currNode = queue.remove();
                if(currNode==null){
                    result.add(-1);
                }
                else{
                    result.add(currNode.data);
                    queue.add(currNode.left);
                    queue.add(currNode.right);
                }
            }
            return result;
        }
        public int height(Node root){
            if(root==null){
                return 1;
            }
            return Math.max(height(root.left), height(root.right))+1;
        }
        public int countNodes(Node root){
            if(root==null){
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
        public int treeSum(Node root){
            if(root==null){
                return 0;
            }
            else{
                return treeSum(root.left)+treeSum(root.right)+root.data;
            }
        }
        public int diameterApp1(Node root){
            if(root==null){
                return 0;
            }
            int leftDiameter = diameterApp1(root.left);
            int leftHeight = height(root.left);
            int rightDiameter = diameterApp1(root.right);
            int rightHeight = height(root.right);
            int selfDiameter = leftHeight+rightHeight+1;
            return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
        }
        public Information diameterApp2(Node root){
            if(root==null){
                return new Information(0,0);
            }
            Information leftInfo = diameterApp2(root.left);
            Information rightInfo = diameterApp2(root.right);
            int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter),leftInfo.height+rightInfo.height+1);
            int height = Math.max(leftInfo.height, rightInfo.height)+1;
            return new Information(diam, height);
        }
        static class Information{
            int diameter;
            int height;
            public Information(int diameter, int height){
                this.diameter = diameter;
                this.height = height;
            }
        }
        public boolean isSubtree(Node root1, Node root2){
            if((root1==null && root2!=null)||(root1!=null && root2==null)){
                return false;
            } else if (root1==null && root2==null) {
                return true;
            } else{
                if(root1.data==root2.data){
                    boolean left = isSubtree(root1.left, root2.left);
                    boolean right = isSubtree(root1.right, root2. left);
                    return left || right;
                }
                else{
                    boolean left = isSubtree(root1.left, root2);
                    boolean right = isSubtree(root1.right, root2);
                    return left || right;
                }
            }
        }
        public HashMap<Integer, Node> topViewRecursive(Node root, int x, HashMap<Integer, Node> map){
            if(root==null){
                return map;
            }
            if(!map.containsKey(x)){
                map.put(x, root);
                System.out.print(root.data+"  ");
            }
            topViewRecursive(root.left, x-1, map);
            topViewRecursive(root.right, x+1, map);
            return map;
        }
        class Info{
            int x;
            Node node;
            Info(int x, Node node){
                this.x = x;
                this.node = node;
            }
        }
        public ArrayList<Integer> topViewIterative(Node root){
            Queue<Info> queue = new LinkedList<>();
            queue.add(new Info(0, root));
            int min = 0;
            int max = 0;
            HashMap<Integer, Integer> map= new HashMap<>();
            while(!queue.isEmpty()){
                Info currNode = queue.remove();
                int dist = currNode.x;
                Node node = currNode.node;
                if(node==null){
                    continue;
                }
                else{
                    queue.add(new Info(dist-1, node.left));
                    queue.add(new Info(dist+1, node.right));
                    if(!map.containsKey(dist)){
                        map.put(dist, node.data);
                    }
                    min = Math.min(min, dist);
                    max = Math.max(max, dist);
                }
            }
            ArrayList<Integer> array = new ArrayList<>();
            for(int i= min; i<=max; i++){
                array.add(map.get(i));
            }
            return array;
        }
        public ArrayList<Integer> kthLevel(Node root, int depth, int k, ArrayList<Integer> arr){
            if(root==null){
                return arr;
            }
            else if(depth==k){
                arr.add(root.data);
                System.out.print(root.data + " ");
                return arr;
            }
            else{
                arr = kthLevel(root.left, depth+1, k, arr);
                arr = kthLevel(root.right, depth+1, k, arr);
                return arr;
            }
        }
        public boolean getPath(Node root, int targetNode, ArrayList<Node> path){
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==targetNode){
                return true;
            }
            boolean foundLeft = getPath(root.left, targetNode, path);
            boolean foundRight = getPath(root.right, targetNode, path);
            if(foundLeft||foundRight){
                return true;
            }
            path.removeLast();
            return false;
        }
        public Node lowestCommonAncestor(Node root, int node1, int node2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
            getPath(root, node1, path1);
            getPath(root, node2, path2);
            Node commonNode = null;
            for(int i=0; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i).data == path2.get(i).data){
                    commonNode = path1.get(i);
                }
            }
            return commonNode;
        }
        public int sumTree(Node root){
            if(root==null){
                return 0;
            }
            int leftChild = sumTree(root.left);
            int rightChild = sumTree(root.right);
            int data = root.data;
            root.data = leftChild + rightChild;
            return data+root.data;
        }
    }
    public static void main(String args[]){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,7,-1,-1,-1,-1};
        BinaryTree b1 = new BinaryTree();
        Node root = b1.buildTreeFromPreOrder(nodes);
        ArrayList<Integer> preorder = b1.preOrderTraversal(root, new ArrayList<>());
        System.out.println(preorder);
        ArrayList<Integer> postorder = b1.postOrderTraversal(root, new ArrayList<>());
        System.out.println(postorder);
        ArrayList<Integer> inorder = b1.inOrderTraversal(root, new ArrayList<>());
        System.out.println(inorder);
        ArrayList<Integer> levelorder = b1.levelOrderTraversal(root);
        System.out.println(levelorder);
        int height = b1.height(root);
        System.out.println(height);
        int count = b1.countNodes(root);
        System.out.println(count);
        int sum = b1.treeSum(root);
        System.out.println(sum);
        int[] nodes2 = {2,4,6,-1,-1,-1,5,-1,-1};
        BinaryTree b2 = new BinaryTree();
        Node root2 = b2.buildTreeFromPreOrder(nodes2);
        boolean temp = b1.isSubtree(root, root2);
        System.out.println(temp);
        HashMap<Integer, Node> map = new HashMap<>();
        System.out.println(b2.topViewRecursive(root2, 0, map));
        System.out.println(b2.topViewIterative(root2));
        System.out.println(b1.kthLevel(root, 1, 1, new ArrayList<>()));
        System.out.println(b2.lowestCommonAncestor(root2, 4, 5).data);
        System.out.println(b1.preOrderTraversal(root, new ArrayList<Integer>()));
        b1.sumTree(root);
        System.out.println(b1.preOrderTraversal(root, new ArrayList<Integer>()));
    }
}


