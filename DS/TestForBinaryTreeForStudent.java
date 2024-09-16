import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Sumitra to test the binary search tree for students.
 */
public class TestForBinaryTreeForStudent {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Student s1 = new Student("a1", 5);
		Student s2 = new Student("a2", 2);
		Student s3 = new Student("a3", 1);
		BinarySearchTreeForStudent binary = new BinarySearchTreeForStudent();
		binary.insert(s1);
		binary.insert(s2);
		binary.insert(s3);
		String result = binary.inorder();
		String expeceted = "a3 1->a2 2->a1 5->";
		assertEquals(expeceted, result);
	}

	@Test
	public void testAgain() {
		Student s1 = new Student("a1", 5);
		Student s2 = new Student("a2", 2);
		Student s3 = new Student("a3", 1);
		Student s4 = new Student("a4", 6);
		BinarySearchTreeForStudent binary = new BinarySearchTreeForStudent();
		binary.insert(s1);
		binary.insert(s2);
		binary.insert(s3);
		binary.insert(s4);
		String result = binary.inorder();
		String expeceted = "a3 1->a2 2->a1 5->a4 6->";
		assertEquals(expeceted, result);
	}

	@Test
	public void testAgainA() {
		Student s1 = new Student("a1", 5);
		Student s2 = new Student("a2", 2);
		Student s3 = new Student("a3", 1);
		Student s4 = new Student("a4", 1);
		BinarySearchTreeForStudent binary = new BinarySearchTreeForStudent();
		binary.insert(s1);
		binary.insert(s2);
		binary.insert(s3);
		binary.insert(s4);
		String result = binary.inorder();
		String expeceted = "a4 1->a3 1->a2 2->a1 5->";
		assertEquals(expeceted, result);
	}

}
