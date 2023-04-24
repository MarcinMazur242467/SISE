

public class App {
    public static void main(String[] args) {

        Node node = DataAccess.initialNode();
        if(BFS.BFS(node, "RDUL")){
            System.out.println("BFS - SUCCESS");
        }else {
            System.out.println("BFS - FALSE");
        }

        if(DFS.DFS(node, "RDUL")){
            System.out.println("DFS - SUCCESS");
        }else{
            System.out.println("DFS - FALSE");
        }

        if(Astar.Astar(node,Node.hammingComparator, "RDUL")){
            System.out.println("Astar hamming - SUCCESS");
        }else{
            System.out.println("Astar hamming - FALSE");
        }

        if(Astar.Astar(node,Node.manhattanComparator, "RDUL")){
            System.out.println("Astar manhattan - SUCCESS");
        }else{
            System.out.println("Astar manhattan - FALSE");
        }
    }
}
