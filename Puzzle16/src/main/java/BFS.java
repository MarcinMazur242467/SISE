import java.util.ArrayDeque;
import java.util.HashSet;

public class BFS {
    public static boolean BFS(Node node, String order) {
        double startTime = System.nanoTime();
        int visited = 1;
        int maxDepth = 0;
        int solutionCounter = 0;
        StringBuilder solution = new StringBuilder();
        if (node.isGoal()) {
            return true;
        }
        ArrayDeque<Node> Q = new ArrayDeque<>();
        HashSet<Node> U = new HashSet<>();
        U.add(node);
        Q.add(node);
        Node v;
        while (!Q.isEmpty()) {
            v = Q.pop();
            for (Node n : v.getNeighbours(order)) {
                visited++;
                if (v.isGoal()) {
                    System.out.println("Visited nodes: " + visited);
                    System.out.println("Processed nodes: " + U.size());
                    System.out.println("Max depth: " + maxDepth);
                    double endTime = System.nanoTime();
                    System.out.println("Execution time: " + String.format("%.3g", ((endTime - startTime) / 1000000)));
                    while (v.getParentNode() != null) {
                        solution.append(v.getOperator());
                        solutionCounter++;
                        v = v.getParentNode();
                    }
                    System.out.println("Solution: " + solution.reverse());
                    System.out.println("Solution length " + solutionCounter);
                    return true;
                }
                if (!U.contains(n)) {
                    Q.add(n);
                    if (n.getDepth() > maxDepth) maxDepth = n.getDepth();
                    U.add(n);
                }
            }
        }
        return false;
    }
}
