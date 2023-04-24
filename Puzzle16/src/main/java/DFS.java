import java.util.*;

public class DFS {
    private static final int maxDepth = 20;
    public static boolean DFS(Node node){
        int counter = 0;
        if(node.isGoal()) return true;
        Stack<Node> S = new Stack<>();
        HashSet<Node> T = new HashSet<>();
        S.push(node);
        while (!S.isEmpty()){
            Node v = S.pop();
            T.add(v);
            List<Node> neighbours = v.getNeighbours();
            Collections.reverse(neighbours);
            for (Node n: neighbours) {
                counter++;
                if(n.isGoal()) {
                    System.out.println("DFS Iterations: " + counter);
                    return true;
                }
                if(!T.contains(n) && !S.contains(n) && n.getDepth()<maxDepth){
                    S.push(n);
                }
            }
        }
        return false;
    }


//    public static boolean DFS(Node node){ kanoniczny dfs
//        int counter = 0;
//        if(node.isGoal()) return true;
//        Stack<Node> S = new Stack<>();
//        HashSet<Node> T = new HashSet<>();
//        S.push(node);
//        while (!S.isEmpty()){
//            Node v = S.pop();
//            if(!T.contains(v)){
//                T.add(v);
//                List<Node> neighbours = v.getNeighbours();
//                Collections.reverse(neighbours);
//                for (Node n: neighbours) {
//                    counter++;
//                    if(n.isGoal()) {
//                        System.out.println("DFS Iterations: " + counter);
//                        return true;
//                    }
//                    if(!T.contains(n) && n.getDepth()<maxDepth) {
//                        S.push(n);
//                    }
//                }
//
//            }
//        }
//        return false;
//    }


}