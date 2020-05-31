package AISD;

public class AWLTree {
    private Node root;

    private class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            height = 1;
            this.left = null;
            this.right = null;
        }
    }

        private int max(int a, int b) {
            return Math.max(a, b);
        }

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        private Node rightRotation(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            x.right = y;
            y.left = T2;

            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;

            return x;
        }

        private Node leftRotate(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            y.left = x;
            x.right = T2;

            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;

            return y;
        }

        private int getBalance(Node node) {
            if (node == null) {
                return 0;
            }

            return height(node.left) - height(node.right);
        }

    Node minValue(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    private Node insert(int value) {
            return insert(root, value);
        }

        private Node insert(Node node, int value) {

            if (node == null) {
                return (new Node(value));
            }

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value)
                node.right = insert(node.right, value);
            else
                return node;

            node.height = 1 + max(height(node.left), height(node.right));

            int balance = getBalance(node);

            if (balance > 1 && value < node.left.value) {
                return rightRotation(node);
            }

            // Right Right Case
            if (balance < -1 && value > node.right.value) {
                return leftRotate(node);
            }

            // Left Right Case
            if (balance > 1 && value > node.left.value) {
                node.left = leftRotate(node.left);
                return rightRotation(node);
            }

            // Right Left Case
            if (balance < -1 && value < node.right.value) {
                node.right = rightRotation(node.right);
                return leftRotate(node);
            }

            return node;
        }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                }
                else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                }
                else {
                    root = temp;
                }
            }
            else {
                Node temp = minValue(root.right);

                root.value = temp.value;

                root.right = deleteNode(root.right, temp.value);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotation(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotation(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotation(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node deleteNode(int value) {
        return deleteNode(root, value);
    }

    public void dfs(Node node) {
            if (node != null) {
                System.out.print(node.value + " ");
                dfs(node.left);
                dfs(node.right);
            }
        }

    public static void main(String[] args) {
        AWLTree tree = new AWLTree();

        tree.root = tree.insert(1);
        tree.root = tree.insert( 2);
        tree.root = tree.insert( 5);
        tree.root = tree.insert(25);
        tree.root = tree.deleteNode(5);

        tree.dfs(tree.root);
    }

}
