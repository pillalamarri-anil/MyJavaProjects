package MultiThread.TreeLevelSumWithCompletableFuture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    List<List<TreeNode>>  getLevelElements(TreeNode root) {

        List<List<TreeNode>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                level.add(n);

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }

            result.add(level);
        }
        return result;
    }
}


public class Client {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<List<TreeNode>> levels = root.getLevelElements(root);

        // create a completed future
        CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
        for(List<TreeNode> level : levels) {
            future = future.thenRunAsync(() -> {
                int sum = 0;
                for(TreeNode node : level) {
                    sum += node.val;
                }
                System.out.println(sum + " ");
            }, executorService);
        }

        future.join();

        executorService.shutdown();
    }
}
