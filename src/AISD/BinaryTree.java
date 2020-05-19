package AISD;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (current.value < value) {
            current.right = add(current.right, value);
        }
        if (current.value > value) {
            current.left = add(current.left, value);
        }

        return current; // if this value already exist
    }

    private void add(int value) {
        root = add(root, value);
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        if (value < current.value) {
            return containsNode(current.left, value);
        }
        if (value > current.value) {
            return containsNode(current.right, value);
        }
        return false;
    }

    private boolean containsNode(int value) {
        return containsNode(root, value);
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node delete(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left != null && current.right == null) {
                return current.left;
            }
            if (current.right != null && current.left == null) {
                return current.right;
            }
            if (current.right != null && current.left != null) {
                int smallestValue = minValue(current.right);
                current.value = smallestValue;
                current.right = delete(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = delete(current.left, value);
            return current;
        }
        if (value > current.value) {
            current.right = delete(current.right, value);
        }
        return current;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private int minValue(Node root) {
        return root.left == null ? root.value : minValue(root.left);
    }

    private void dfs(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            dfs(node.left);
            dfs(node.right);
        }
    }

    private void bfs() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.delete(3);
        System.out.println(binaryTree.containsNode(3));
        binaryTree.dfs(binaryTree.root);
        System.out.println();
        binaryTree.bfs();
        AWLTree awlTree = new AWLTree();
    }
}
