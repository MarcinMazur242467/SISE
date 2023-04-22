import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import static java.util.Collections.reverse;

public class DFS {
    private static int maxDepth = 30;
    public static boolean DFS(Node node){
        int counter = 0;
        if(node.isGoal()) return true;
        Stack<Node> S = new Stack<>();
        HashSet<Node> T = new HashSet<>();
        S.push(node);
        int depth = 0;
        while (!S.isEmpty()){
            Node v = S.pop();
            T.add(v);
            List<Node> neighbours = v.getNeighbours();
            Collections.reverse(neighbours);
            for (Node n: neighbours) {
                counter++;
                if(n.isGoal()){
                    System.out.println("DFS Iterations: "+counter);
                    return true;
                }
                if(!T.contains(n) && !S.contains(n) && depth < maxDepth) {
                    depth++;
                    S.push(n);
                }
            }
            depth--;
        }
        return false;
    }
}
