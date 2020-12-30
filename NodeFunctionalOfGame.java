import java.io.Serializable;

public class NodeFunctionalOfGame implements Serializable {
    private int id;
    private NodeWithText nodeWithText;
    private NodeFunctionalOfGame nextSolutionOne;
    private NodeFunctionalOfGame nextSolutionTwo;
    private boolean flag;


    public boolean isFlag() {
        return flag;
    }

    public NodeFunctionalOfGame(int id) {
        StringBuilder node = new StringBuilder();
        node.append("NODE").append(id); //   NODE1, NODE2, NODE3...
        this.nodeWithText = NodeWithText.valueOf(node.toString());
        this.id = id;
        this.flag = true;
    }

    public NodeWithText getNode() {
        return nodeWithText;
    }

    public NodeFunctionalOfGame getLinkNextSolutionTwo() {
        return nextSolutionTwo;
    }

    public NodeFunctionalOfGame getLinkNextSolutionOne() {
        return nextSolutionOne;
    }

    public void setNextSolutionOne(NodeFunctionalOfGame oneSolution) {
        this.nextSolutionOne = oneSolution;
    }

    public void setNextSolutionTwo(NodeFunctionalOfGame twoSolution) {
        this.nextSolutionTwo = twoSolution;
    }


}
