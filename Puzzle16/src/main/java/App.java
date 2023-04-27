import java.util.Objects;

public class App {
    public static void main(String[] args) {
        Node node = DataAccess.initialNode(args[2]);
        switch (args[0]) {
            case "bfs" -> {
                if (BFS.BFS(node, args[1], args[3], args[4])) {
                    System.out.println("BFS - SUCCESS");
                } else {
                    System.out.println("BFS - FALSE");
                }
            }
            case "dfs" -> {
                if (DFS.DFS(node, args[1], args[3], args[4])) {
                    System.out.println("DFS - SUCCESS");
                } else {
                    System.out.println("DFS - FALSE");
                }
            }
            case "astr" -> {
                if (Objects.equals(args[1], "manh")) {
                    if (Astar.Astar(node, Node.manhattanComparator, args[3], args[4])) {
                        System.out.println("Astar hamming - SUCCESS");
                    } else {
                        System.out.println("Astar hamming - FALSE");
                    }
                } else if (Objects.equals(args[1], "hamm")) {
                    if (Astar.Astar(node, Node.hammingComparator, args[3], args[4])) {
                        System.out.println("Astar hamming - SUCCESS");
                    } else {
                        System.out.println("Astar hamming - FALSE");
                    }
                }
            }
        }

//        Node node = DataAccess.initialNode("D:\\JavaProjects\\SISE\\Puzzle16\\src\\main\\resources\\test.txt");
//        if (BFS.BFS(node, "RDUL", "BFS_Solution", "BFS_Stats")) {
//            System.out.println("BFS - SUCCESS");
//        } else {
//            System.out.println("BFS - FALSE");
//        }
//        System.out.println("\n");
//        if (DFS.DFS(node, "RDUL", "DFS_Solution", "DFS_Stats")) {
//            System.out.println("DFS - SUCCESS");
//        } else {
//            System.out.println("DFS - FALSE");
//        }
//        System.out.println("\n");
//        if (Astar.Astar(node, Node.hammingComparator, "AstrHamm_Solution", "AstrHamm_Stats")) {
//            System.out.println("Astar hamming - SUCCESS");
//        } else {
//            System.out.println("Astar hamming - FALSE");
//        }
//        System.out.println("\n");
//        if (Astar.Astar(node, Node.manhattanComparator, "AstrManh_Solution", "AstrManh_Stats")) {
//            System.out.println("Astar manhattan - SUCCESS");
//        } else {
//            System.out.println("Astar manhattan - FALSE");
//        }
    }
}
