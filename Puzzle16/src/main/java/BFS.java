import java.util.ArrayDeque;
import java.util.HashSet;

public class BFS {
//    function bfs(G, s)// graf i stan poczatkowy
//	if(G.isGoal(s))
//            return SUCCESS
//    Q = queue()//kolejka
//    U = set()//lista stanow osiaganietych
//	U.add(s)
//            Q.enqueue(s)
//            while(!Q.isEmpty())
//    v = Q.dequeue()
//            for n in G.neighbours(v)
//            if(!U.has(n))
//            if G.isGoal(n)
//            return SCUUCESS
//				Q.enqueues(n)
//            U.add(n)
//            return FAILURE
    public static boolean BFS(Node node){
        if(node.isGoal()){
            return true;
        }
        ArrayDeque<Node> Q = new ArrayDeque<Node>();
        HashSet<Node> U= new HashSet<>();
        U.add(node);
        Q.add(node);
        node.printState();
        while(!Q.isEmpty()){
           Node v = Q.pop();
            for (Node n: v.getNeighbours()) {
                n.printState();
                if(n.isGoal()) {
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
