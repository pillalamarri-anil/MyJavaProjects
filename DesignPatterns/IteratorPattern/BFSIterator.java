package DesignPatterns.IteratorPattern;

import java.util.LinkedList;
import java.util.Queue;

public class BFSIterator implements Iterator {

    private Queue<TreeNode> queue;

    public BFSIterator(TreeNode root) {
        queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("No more elements in the tree");
        }
        TreeNode currentNode = queue.poll();
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        return currentNode.data;
    }
}
