
public class App {
    public static void main(String[] args) {

        Node node = DataAccess.initialNode();
        node.printState();
        Node node2 = node.LEFT();
        node2.printState();
    }
}
