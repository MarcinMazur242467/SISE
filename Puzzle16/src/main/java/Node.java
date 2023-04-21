import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Node {

    private final Node parentNode;
    private final int [][] state;
    private final int zeroPos_X;
    private final int zeroPos_Y;
    private final char operator;


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        return Arrays.deepEquals(state, other.state);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(state);
    }



    public int[][] getState(){
        return this.state;
    }

    public Node(Node parentNode, int[][] state, int zeroPos_X, int zeroPos_Y, char operator) {
        this.parentNode = parentNode;
        this.state = state;
        this.zeroPos_X = zeroPos_X;
        this.zeroPos_Y = zeroPos_Y;
        this.operator = operator;
    }

    private int[][] moveTile(int[][] state, int x1, int y1, int x2, int y2) {
        int[][] newState = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newState[i][j] = state[i][j];
            }
        }
        int temp = newState[x1][y1];
        newState[x1][y1] = newState[x2][y2];
        newState[x2][y2] = temp;
        if (Arrays.deepEquals(newState, state)) {
            return null;
        }
        return newState;
    }

    public Node getParentNode() {
        return parentNode;
    }
    public int getZeroPos_X() {
        return  zeroPos_X;
    }

    public int getZeroPos_Y() {
        return zeroPos_Y;
    }
    public char getOperator() {
        return operator;
    }

    public void  printState(){
        System.out.println();
        System.out.println("Parent: "+getParentNode());
        System.out.println("X: "+getZeroPos_X());
        System.out.println("Y: "+getZeroPos_Y());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                builder.append(getState()[i][j]+"  ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
        System.out.println("Op: "+getOperator());
    }

    public boolean isGoal(){
        int[][] lista = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(getState()[i][j] != lista[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Node> getNeighbours() {
        int[][] state = getState();
        List<Node> list = new ArrayList<>();
        if (getZeroPos_Y() != 3) {
            int[][] right = moveTile(state, getZeroPos_X(), getZeroPos_Y(), getZeroPos_X(), getZeroPos_Y() + 1);
            Node rightNode = new Node(this,right,getZeroPos_X(),getZeroPos_Y() + 1,'R');
            if (right != null) {
                list.add(rightNode);
            }
        }
        if (getZeroPos_X() != 0) {
            int[][] up = moveTile(state, getZeroPos_X(), getZeroPos_Y(), getZeroPos_X()-1, getZeroPos_Y());
            Node upNode = new Node(this,up,getZeroPos_X()-1,getZeroPos_Y(),'U');
            if (up != null) {
                list.add(upNode);
            }
        }
        if (getZeroPos_Y() != 0) {
            int[][] left = moveTile(state, getZeroPos_X(), getZeroPos_Y(), getZeroPos_X(), getZeroPos_Y() - 1);
            Node leftNode = new Node(this,left,getZeroPos_X(),getZeroPos_Y() - 1,'L');
            if (left != null) {
                list.add(leftNode);
            }
        }
        if (getZeroPos_X() != 3) {
            int[][] down = moveTile(state, getZeroPos_X(), getZeroPos_Y(), getZeroPos_X()+1, getZeroPos_Y());
            Node downNode = new Node(this,down,getZeroPos_X()+1,getZeroPos_Y(),'D');
            if (down != null) {
                list.add(downNode);
            }
        }
        return list;
    }

}
