import java.util.ArrayDeque;
import java.util.HashSet;

public class BFS {
    public static boolean BFS(Node node, String order, String solutionFileName, String statsFileName) {
        double startTime = System.nanoTime();
        StringBuilder statsFile = new StringBuilder();
        StringBuilder solutionFile = new StringBuilder();
        int visited = 1;
        int maxDepth = 0;
        int solutionCounter = 0;
        StringBuilder solution = new StringBuilder();
        if (node.isGoal()) {
            double endTime = System.nanoTime();
            statsFile.append(0).append("\n").append(1).append("\n").append(visited).append("\n").append(0).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
            DataAccess.write(statsFileName, statsFile);
            solutionFile.append(0);
            DataAccess.write(solutionFileName, solutionFile);
            return true;
        }
        ArrayDeque<Node> nodesQueue = new ArrayDeque<>();
        HashSet<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(node);
        nodesQueue.add(node);
        Node v;
        while (!nodesQueue.isEmpty()) {
            v = nodesQueue.pop();
            if (v.getDepth() > maxDepth) maxDepth = v.getDepth();
            for (Node n : v.getNeighbours(order)) {
                visited++;
                if (v.isGoal()) {
                    double endTime = System.nanoTime();
                    while (v.getParentNode() != null) {
                        solution.append(v.getOperator());
                        solutionCounter++;
                        v = v.getParentNode();
                    }
                    statsFile.append(solutionCounter).append("\n").append(visited).append("\n").append(visitedNodes.size()).append("\n").append(maxDepth).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
                    DataAccess.write(statsFileName, statsFile);
                    solutionFile.append(solutionCounter).append("\n").append(solution.reverse());
                    DataAccess.write(solutionFileName, solutionFile);
                    return true;
                }
                if (!visitedNodes.contains(n)) {
                    nodesQueue.add(n);
                    visitedNodes.add(n);
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
