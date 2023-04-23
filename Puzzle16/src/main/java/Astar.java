import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Astar {
    public static boolean Astar(Node node,Comparator<Node> nodeComparator){
        int counter = 0;
        PriorityQueue<Node> P = new PriorityQueue<>(nodeComparator);
        HashSet<Node> T = new HashSet<>();
        P.add(node);
        while (!P.isEmpty()){
            Node v = P.poll();
            if(!T.contains(v)){
                counter++;
                if(v.isGoal()){
                    System.out.println("Astar iterations: "+counter);
                    return true;
                }
                T.add(v);
                for (Node n: v.getNeighbours()) {
                    if(!T.contains(n)){
                        // trzeba tu jeszcze obliczc dotychczasowy czas dotarcia do wezla i brac pod uwage w comparatorze
                        P.add(n);
                    }
                }
            }
        }
        return false;
    }



}
