import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Astar {
    public static boolean Astar(Node node, Comparator<Node> nodeComparator, String solutionFileName, String statsFileName) {
        double startTime = System.nanoTime();
        StringBuilder statsFile = new StringBuilder();
        StringBuilder solutionFile = new StringBuilder();
        int visited = 1;
        int maxDepth = 0;
        StringBuilder solution = new StringBuilder();
        int solutionLength = 0;
        PriorityQueue<Node> nodesQueue = new PriorityQueue<>(nodeComparator);
        HashSet<Node> visitedNodes = new HashSet<>();
        nodesQueue.add(node);
        while (!nodesQueue.isEmpty()) {
            Node v = nodesQueue.poll();
            if (!visitedNodes.contains(v)) {
                if (v.isGoal()) {
                    double endTime = System.nanoTime();
                    while (v.getParentNode() != null) {
                        solution.append(v.getOperator());
                        solutionLength++;
                        v = v.getParentNode();
                    }
                    statsFile.append(solutionLength).append("\n").append(visited).append("\n").append(visitedNodes.size()).append("\n").append(maxDepth).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
                    DataAccess.write(statsFileName, statsFile);
                    solutionFile.append(solutionLength).append("\n").append(solution.reverse());
                    DataAccess.write(solutionFileName, solutionFile);
                    return true;
                }
                visitedNodes.add(v);
                for (Node n : v.getNeighbours(null)) {
                    visited++;
                    if (!visitedNodes.contains(n)) {
                        if (maxDepth < n.getDepth()) maxDepth = n.getDepth();
                        nodesQueue.add(n);
                    }
                }
            }
        }
        double endTime = System.nanoTime();
        statsFile.append(-1).append("\n").append(visited).append("\n").append(visitedNodes.size()).append("\n").append(maxDepth).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
        DataAccess.write(statsFileName, statsFile);
        solutionFile.append(-1);
        DataAccess.write(solutionFileName, solutionFile);
        return false;
    }


}
