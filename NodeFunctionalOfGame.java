import java.io.Serializable;

public class NodeFunctionalOfGame implements Serializable {
    private int id;
    private NodeWithText nodeWithText;
    private NodeFunctionalOfGame nextSolutionOne;
    private NodeFunctionalOfGame nextSolutionTwo;

    public NodeFunctionalOfGame(int id) {
        StringBuilder node = new StringBuilder();
        node.append("NODE").append(id); //   NODE1, NODE2, NODE3...
        this.nodeWithText = NodeWithText.valueOf(node.toString());
        this.id = id;
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

    public void setNextSolutionOne(NodeFunctionalOfGame rightAnswer) {
        this.nextSolutionOne = rightAnswer;
    }

    public void setNextSolutionTwo(NodeFunctionalOfGame wrongAnswer) {
        this.nextSolutionTwo = wrongAnswer;
    }


}
