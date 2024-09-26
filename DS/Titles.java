/**
 * @author Sumitra this is the POJO class for titles class.
 */
public class Titles {
	int title_id;
	String title_nm;
	int subject_id;
	int publisher_id;

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public String getTitle_nm() {
		return title_nm;
	}

	public void setTitle_nm(String title_nm) {
		this.title_nm = title_nm;
	}

	public int getSubject_id() {
		return subject_id;
	}

	public Titles(int title_id, String title_nm, int subject_id,
			int publisher_id) {
		super();
		this.title_id = title_id;
		this.title_nm = title_nm;
		this.subject_id = subject_id;
		this.publisher_id = publisher_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
}
