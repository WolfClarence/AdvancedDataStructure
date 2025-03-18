// SplayTree.java
// Implements a Splay Tree, a self-adjusting binary search tree.
public class SplayTree extends BinarySearchTree {

    // Splay the tree to bring the node with the given name to the root
    private FileNode splay(FileNode node, String name) {
        if (node == null || node.name.equals(name)) {
            return node;
        }

        // Split the tree into three parts: Left, Right and Root
        if (name.compareTo(node.name) < 0) {
            // If the key is in the left subtree
            if (node.left == null) return node;

            // Zig-Zig (Left-Left)
            if (name.compareTo(node.left.name) < 0) {
                node.left.left = splay(node.left.left, name);
                node = rotateRight(node);
            }
            // Zig-Zag (Left-Right)
            else if (name.compareTo(node.left.name) > 0) {
                node.left.right = splay(node.left.right, name);
                if (node.left.right != null) {
                    node.left = rotateLeft(node.left);
                }
            }
            return (node.left == null) ? node : rotateRight(node);
        } else {
            // If the key is in the right subtree
            if (node.right == null) return node;

            // Zag-Zag (Right-Right)
            if (name.compareTo(node.right.name) > 0) {
                node.right.right = splay(node.right.right, name);
                node = rotateLeft(node);
            }
            // Zag-Zig (Right-Left)
            else if (name.compareTo(node.right.name) < 0) {
                node.right.left = splay(node.right.left, name);
                if (node.right.left != null) {
                    node.right = rotateRight(node.right);
                }
            }
            return (node.right == null) ? node : rotateLeft(node);
        }
    }

    // Override insert method to use Splay Tree insertion
    @Override
    public void insert(String name, int size) {
        root = insertRec(root, name, size);
        root = splay(root, name);  // Splay the tree after insertion
    }

    // Recursive insert method to add a new node
    private FileNode insertRec(FileNode node, String name, int size) {
        if (node == null) return new FileNode(name, size);

        if (name.compareTo(node.name) < 0) {
            node.left = insertRec(node.left, name, size);
        } else if (name.compareTo(node.name) > 0) {
            node.right = insertRec(node.right, name, size);
        }

        return node;
    }

    // Perform a right rotation
    private FileNode rotateRight(FileNode node) {
        FileNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    // Perform a left rotation
    private FileNode rotateLeft(FileNode node) {
        FileNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }
}
