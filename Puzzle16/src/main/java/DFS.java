import java.util.*;

public class DFS {
    private static final int maxDepth = 20;

    public static boolean DFS(Node node, String order, String solutionFileName, String statsFileName) {
        double startTime = System.nanoTime();
        StringBuilder statsFile = new StringBuilder();
        StringBuilder solutionFile = new StringBuilder();
        int visited = 1;
        int localMaxDepth = 0;
        StringBuilder solution = new StringBuilder();
        int solutionLength = 0;
        if (node.isGoal()) {
            double endTime = System.nanoTime();
            statsFile.append(0).append("\n").append(1).append("\n").append(visited).append("\n").append(0).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
            DataAccess.write(statsFileName, statsFile);
            solutionFile.append(0);
            DataAccess.write(solutionFileName, solutionFile);
            return true;
        }
        Stack<Node> nodesStack = new Stack<>();
        HashSet<Node> visitedNodes = new HashSet<>();
        nodesStack.push(node);
        while (!nodesStack.isEmpty()) {
            Node v = nodesStack.pop();
            visitedNodes.add(v);
            List<Node> neighbours = v.getNeighbours(order);
            Collections.reverse(neighbours);
            for (Node n : neighbours) {
                visited++;
                if (n.getDepth() > localMaxDepth) localMaxDepth = n.getDepth();
                if (n.isGoal()) {
                    System.out.println(localMaxDepth);
                    double endTime = System.nanoTime();
                    while (n.getParentNode() != null) {
                        solution.append(n.getOperator());
                        solutionLength++;
                        n = n.getParentNode();
                    }
                    statsFile.append(solutionLength).append("\n").append(visited).append("\n").append(visitedNodes.size()).append("\n").append(localMaxDepth).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
                    DataAccess.write(statsFileName, statsFile);
                    solutionFile.append(solutionLength).append("\n").append(solution.reverse());
                    DataAccess.write(solutionFileName, solutionFile);
                    return true;
                }
                if (!visitedNodes.contains(n) && !nodesStack.contains(n) && n.getDepth() <= maxDepth) {
                    nodesStack.push(n);
                }
            }
        }
        double endTime = System.nanoTime();
        statsFile.append(-1).append("\n").append(visited).append("\n").append(visitedNodes.size()).append("\n").append(localMaxDepth).append("\n").append(String.format("%.3g", ((endTime - startTime) / 1000000)));
        DataAccess.write(statsFileName, statsFile);
        solutionFile.append(-1);
        DataAccess.write(solutionFileName, solutionFile);
        return false;
    }


}