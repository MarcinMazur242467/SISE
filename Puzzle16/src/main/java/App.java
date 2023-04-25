import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Node node = DataAccess.initialNode("D:\\JavaProjects\\SISE\\Puzzle16\\src\\main\\resources\\test.txt");
        if (BFS.BFS(node, "RDUL")) {
            System.out.println("BFS - SUCCESS");
        } else {
            System.out.println("BFS - FALSE");
        }
        System.out.println("\n");
        if (DFS.DFS(node, "RDUL")) {
            System.out.println("DFS - SUCCESS");
        } else {
            System.out.println("DFS - FALSE");
        }
        System.out.println("\n");
        if (Astar.Astar(node, Node.hammingComparator)) {
            System.out.println("Astar hamming - SUCCESS");
        } else {
            System.out.println("Astar hamming - FALSE");
        }
        System.out.println("\n");
        if (Astar.Astar(node, Node.manhattanComparator)) {
            System.out.println("Astar manhattan - SUCCESS");
        } else {
            System.out.println("Astar manhattan - FALSE");
        }


//        Node node = DataAccess.initialNode(args[2]);
//        switch (args[0]) {
//            case "bfs" -> {
//                if (BFS.BFS(node, args[1])) {
//                    System.out.println("BFS - SUCCESS");
//                } else {
//                    System.out.println("BFS - FALSE");
//                }
//            }
//            case "dfs" -> {
//                if (DFS.DFS(node, args[1])) {
//                    System.out.println("DFS - SUCCESS");
//                } else {
//                    System.out.println("DFS - FALSE");
//                }
//            }
//            case "astr" -> {
//                if (Objects.equals(args[1], "manh")) {
//                    if (Astar.Astar(node, Node.manhattanComparator)) {
//                        System.out.println("Astar hamming - SUCCESS");
//                    } else {
//                        System.out.println("Astar hamming - FALSE");
//                    }
//                } else if (Objects.equals(args[1], "hamm")) {
//                    if (Astar.Astar(node, Node.hammingComparator)) {
//                        System.out.println("Astar hamming - SUCCESS");
//                    } else {
//                        System.out.println("Astar hamming - FALSE");
//                    }
//                }
//            }
//        }
    }
}
