package DesignPatterns.IteratorPattern;

import java.util.Stack;

public class DFSIterator implements Iterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public DFSIterator(TreeNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public int next() {

        if (!hasNext()) {
            throw new RuntimeException("No more elements in the tree");
        }
        TreeNode currentNode = stack.pop();
        // Push right child first so that left child is processed first
        if (currentNode.right != null) {
            stack.push(currentNode.right);
        }
        if (currentNode.left != null) {
            stack.push(currentNode.left);
        }
        return currentNode.data;
    }
}
