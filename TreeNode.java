package Assignment21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node1 
{
    int val;
    Node1 left, right;
    public Node1(int val) 
    {
        this.val = val;
        left = right = null;
    }
}
public class TreeNode 
{
    public static void main(String[] args) 
    {
    	Node1 root = new Node1(10);
        root.left = new Node1(2);
        root.right = new Node1(7);
        root.left.left = new Node1(8);
        root.left.right = new Node1(4);
        convertToBST(root);
        inorderTraversal(root);
    }
    public static void convertToBST(Node1 root) 
    {
        List<Integer> values = new ArrayList<>();
        storeValues(root, values);
        Collections.sort(values);
        updateNodeValues(root, values, new int[]{0});
    }
    public static void storeValues(Node1 node, List<Integer> values) 
    {
        if (node == null) 
        {
            return;
        }
        values.add(node.val);
        storeValues(node.left, values);
        storeValues(node.right, values);
    }
    public static void updateNodeValues(Node1 node, List<Integer> values, int[] index) 
    {
        if (node == null) 
        {
            return;
        }
        updateNodeValues(node.left, values, index);
        node.val = values.get(index[0]);
        index[0]++;
        updateNodeValues(node.right, values, index);
    }
    public static void inorderTraversal(Node1 root) 
    {
        if (root == null) 
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
}

