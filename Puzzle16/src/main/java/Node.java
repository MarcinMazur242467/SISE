
public class Node {
    private  Node parentNode;
    private int [][] state;
    private int zeroPos_X;
    private int zeroPos_Y;
    private char operator;

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
    public Node LEFT(){
        int[][] state = getState();
        state[zeroPos_X][zeroPos_Y] = state[zeroPos_X][zeroPos_Y-1];
        state[zeroPos_X][zeroPos_Y-1]=0;
        return new Node(this,state,zeroPos_X,zeroPos_Y-1,'L');
    }
    public Node RIGHT() {
        int[][] state = getState();
        state[zeroPos_X][zeroPos_Y] = state[zeroPos_X][zeroPos_Y + 1];
        state[zeroPos_X][zeroPos_Y + 1] = 0;
        return new Node(this, state, zeroPos_X, zeroPos_Y + 1, 'R');
    }

    public Node UP(){
        int[][] state = getState();
        state[zeroPos_X][zeroPos_Y] = state[zeroPos_X-1][zeroPos_Y];
        state[zeroPos_X-1][zeroPos_Y]=0;
        return new Node(this, state, zeroPos_X-1, zeroPos_Y, 'U');
    } public Node DOWN(){
        int[][] state = getState();
        state[zeroPos_X][zeroPos_Y] = state[zeroPos_X+1][zeroPos_Y];
        state[zeroPos_X+1][zeroPos_Y]=0;
        return new Node(this, state, zeroPos_X+1, zeroPos_Y, 'D');
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

}
