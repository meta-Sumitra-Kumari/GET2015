/**
 * @author Sumitra this is the node class which will contain elements.
 */
public class Node {
	Student studentNode;
	Node leftNode;
	Node rightNode;

	public Node(Student studentNode) {
		super();
		this.studentNode = studentNode;
		this.leftNode = null;
		this.rightNode = null;
	}

	public Student getStudentNode() {
		return studentNode;
	}

	public void setStudentNode(Student studentNode) {
		this.studentNode = studentNode;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
