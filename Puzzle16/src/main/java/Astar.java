import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Astar {
    public static boolean Astar(Node node, Comparator<Node> nodeComparator) {
        double startTime = System.nanoTime();
        int visited = 1;
        int maxDepth = 0;
        StringBuilder solution = new StringBuilder();
        int solutionLength = 0;
        PriorityQueue<Node> P = new PriorityQueue<>(nodeComparator);
        HashSet<Node> T = new HashSet<>();
        P.add(node);
        while (!P.isEmpty()) {
            Node v = P.poll();
            if (!T.contains(v)) {
                if (v.isGoal()) {
                    System.out.println("Visited nodes: " + visited);
                    System.out.println("Processed nodes: " + T.size());
                    System.out.println("Max depth: " + maxDepth);
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
                T.add(v);
                for (Node n : v.getNeighbours(null)) {
                    visited++;
                    if (!T.contains(n)) {
                        if (maxDepth < n.getDepth()) maxDepth = n.getDepth();
                        P.add(n);
                    }
                }
            }
        }
        return false;
    }


}
