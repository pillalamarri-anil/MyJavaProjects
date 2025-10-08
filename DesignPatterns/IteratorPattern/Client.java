package DesignPatterns.IteratorPattern;

public class Client {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        Iterator bfsIterator = new BFSIterator(root);
        Iterator dfsIterator = new DFSIterator(root);

        while (bfsIterator.hasNext()) {
            System.out.println(bfsIterator.next());
        }

        while (dfsIterator.hasNext()) {
            System.out.println(dfsIterator.next());
        }
    }
}
