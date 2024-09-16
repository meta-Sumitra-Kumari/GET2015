/**
 * @author Sumitra this is to implement the binary search tree
 */
public class BinarySearchTreeForStudent {

	Node root;

	public BinarySearchTreeForStudent() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 
	 * @param data
	 *            is the node to insert in tree
	 */
	public void insert(Student data) {
		root = insert(root, data);
	}

	public Node insert(Node node, Student data) {
		if (node == null) {
			return node = new Node(data);
		} else {
			if (data.getStudentRollNo() <= node.getStudentNode()
					.getStudentRollNo()) {
				node.leftNode = insert(node.leftNode, data);
			} else {
				node.rightNode = insert(node.rightNode, data);
			}
		}
		return node;

	}

	/*
	 * this is to take out the inorder of tree.
	 */
	public String inorder() {
		return inorder(root);
	}

	String result = "";

	private String inorder(Node r) {
		if (r != null) {
			inorder(r.getLeftNode());
			result += (r.getStudentNode().getName() + " "
					+ r.getStudentNode().getStudentRollNo() + "->");

			inorder(r.getRightNode());
		}
		return result;
	}

}
