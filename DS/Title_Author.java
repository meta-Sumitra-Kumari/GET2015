/**
 * @author Sumitra this is the POJO class for title author.
 */
public class Title_Author {
	public Title_Author(int title_id, int author_id) {
		super();
		this.title_id = title_id;
		this.author_id = author_id;
	}

	int title_id;
	int author_id;

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
}
