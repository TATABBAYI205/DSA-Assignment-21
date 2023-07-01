package Assignment21;

class Node3 
{
    int val;
    Node3 left, right;
    public Node3(int val) 
    {
        this.val = val;
        left = right = null;
    }
}
class DoublyLinkedListNode 
{
    int val;
    DoublyLinkedListNode prev, next;
    public DoublyLinkedListNode(int val) 
    {
        this.val = val;
        prev = next = null;
    }
}

public class DoublyLL 
{
    Node3 root;
    DoublyLinkedListNode head, prev;
    public static void main(String[] args) 
    {
        DoublyLL tree = new DoublyLL();
        tree.root = new Node3(10);
        tree.root.left = new Node3(5);
        tree.root.right = new Node3(20);
        tree.root.right.left = new Node3(30);
        tree.root.right.right = new Node3(35);

        DoublyLinkedListNode doublyLinkedList = tree.convertToDoublyLinkedList();
        tree.printDoublyLinkedList(doublyLinkedList);
    }

    public DoublyLinkedListNode convertToDoublyLinkedList() 
    {
        if (root == null)
            return null;
        convertToDoublyLinkedListHelper(root);
        return head;
    }
    private void convertToDoublyLinkedListHelper(Node3 node) 
    {
        if (node == null)
            return;
        convertToDoublyLinkedListHelper(node.left);
        DoublyLinkedListNode currentNode = new DoublyLinkedListNode(node.val);
        if (prev == null) 
        {
            head = currentNode;
        } 
        else 
        {
            prev.next = currentNode;
            currentNode.prev = prev;
        }
        prev = currentNode;
        convertToDoublyLinkedListHelper(node.right);
    }
    public void printDoublyLinkedList(DoublyLinkedListNode head) 
    {
        DoublyLinkedListNode current = head;
        while (current != null) 
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

