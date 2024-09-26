
/**
 * @author Sumitra
 *this is the POJO class for Author.
 */
public class Author {
	public Author(int author_id, String author_name) {
		super();
		this.author_id = author_id;
		this.author_name = author_name;
	}

	int author_id;
	String author_name;

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
}
