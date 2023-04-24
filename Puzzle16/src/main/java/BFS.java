import java.util.ArrayDeque;
import java.util.HashSet;

public class BFS {
    public static boolean BFS(Node node, String order){
        int counter = 0;
        if(node.isGoal()){
            return true;
        }
        ArrayDeque<Node> Q = new ArrayDeque<>();
        HashSet<Node> U= new HashSet<>();
        U.add(node);
        Q.add(node);
        Node v;
//        node.printState();
        while(!Q.isEmpty()){
           v = Q.pop();
            for (Node n: v.getNeighbours(order)) {
                counter++;
                if(v.isGoal()) {
                    System.out.println("BFS iterations: "+counter);
//                    v.printState();
                    return true;}
                if(!U.contains(n)){
                    Q.add(n);
                    U.add(n);
                }
            }
        }
        return false;
    }
}
