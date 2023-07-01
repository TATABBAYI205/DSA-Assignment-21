package Assignment21;

class Node2 
{
    int val;
    Node2 left, right;
    public Node2(int val) 
    {
        this.val = val;
        left = right = null;
    }
}
public class BinarySearchTree 
{
    public static void main(String[] args) 
    {
    	Node2 root = new Node2(8);
        root.left = new Node2(3);
        root.right = new Node2(10);
        root.left.left = new Node2(1);
        root.left.right = new Node2(6);
        root.left.right.left = new Node2(4);
        root.left.right.right = new Node2(7);
        root.right.right = new Node2(14);
        root.right.right.left = new Node2(13);
        int node1 = 6;
        int node2 = 14;
        int distance = findDistance(root, node1, node2);
        System.out.println(distance);
    }
    public static int findDistance(Node2 root, int node1, int node2) 
    {
    	Node2 lca = findLCA(root, node1, node2);
        int distance1 = findDistanceFromNode(lca, node1, 0);
        int distance2 = findDistanceFromNode(lca, node2, 0);
        return distance1 + distance2;
    }
    public static Node2 findLCA(Node2 root, int node1, int node2) 
    {
        if (root == null) 
        {
            return null;
        }
        if (root.val > node1 && root.val > node2) 
        {
            return findLCA(root.left, node1, node2);
        } 
        else if (root.val < node1 && root.val < node2) 
        {
            return findLCA(root.right, node1, node2);
        } 
        else 
        {
            return root;
        }
    }
    public static int findDistanceFromNode(Node2 node, int target, int distance) 
    {
        if (node == null) 
        {
            return -1;
        }
        if (node.val == target) 
        {
            return distance;
        } 
        else if (node.val > target) 
        {
            return findDistanceFromNode(node.left, target, distance + 1);
        } 
        else 
        {
            return findDistanceFromNode(node.right, target, distance + 1);
        }
    }
}

