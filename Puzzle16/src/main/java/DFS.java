import java.util.*;

public class DFS {
    private static final int maxDepth = 20;

    public static boolean DFS(Node node, String order) {
        double startTime = System.nanoTime();
        int visited = 1;
        int localMaxDepth = 0;
        StringBuilder solution = new StringBuilder();
        int solutionLength = 0;
        if (node.isGoal()) return true;
        Stack<Node> S = new Stack<>();
        HashSet<Node> T = new HashSet<>();
        S.push(node);
        while (!S.isEmpty()) {
            Node v = S.pop();
            T.add(v);
            List<Node> neighbours = v.getNeighbours(order);
            Collections.reverse(neighbours);
            for (Node n : neighbours) {
                visited++;
                if (n.isGoal()) {
                    System.out.println("Visited nodes: " + visited);
                    System.out.println("Processed nodes: " + T.size());
                    System.out.println("Max depth: " + localMaxDepth);
                    double endTime = System.nanoTime();
                    System.out.println("Execution time: " + String.format("%.3g", ((endTime - startTime) / 1000000)));
                    while (v.getParentNode() != null) {
                        solution.append(v.getOperator());
                        solutionLength++;
                        v = v.getParentNode();
                    }
                    System.out.println("Solution: " + solution.reverse());
                    System.out.println("Solution length: " + solutionLength);
                    return true;
                }
                if (!T.contains(n) && !S.contains(n) && n.getDepth() <= maxDepth) {
                    if (localMaxDepth < n.getDepth()) localMaxDepth = n.getDepth();
                    S.push(n);
                }
            }
        }
        return false;
    }


}