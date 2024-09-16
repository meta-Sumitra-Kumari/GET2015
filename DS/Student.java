/**
 * @author Sumitra will store information about student.
 */
public class Student {
	String name;
	int studentRollNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Student(String name, int studentRollNo) {

		this.name = name;
		this.studentRollNo = studentRollNo;
	}

}
