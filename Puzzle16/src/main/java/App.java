
public class App {
    public static void main(String[] args) {

        Node node = DataAccess.initialNode();
        if(BFS.BFS(node)){
            System.out.println("SUCCESS");
        }else{
            System.out.println("FALSE");
        }

    }
}
