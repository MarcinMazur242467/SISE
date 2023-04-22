import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        Node node = DataAccess.initialNode();
        if(BFS.BFS(node)){
            System.out.println("BFS - SUCCESS");
        }else {
            System.out.println("BFS - FALSE");
        }
        if(DFS.DFS(node)){
            System.out.println("DFS - SUCCESS");
        }else{
            System.out.println("DFS - FALSE");
        }

    }
}
