import java.util.Date;

/**
 * @author Sumitra
 * this is the POJO class for book.
 */
public class Book {
	int accession_no;
	int title_id;
	Date date;
	float price;
	int status;

	public Book(int accession_no, int title_id, Date date, float price,
			int status) {
		super();
		this.accession_no = accession_no;
		this.title_id = title_id;
		this.date = date;
		this.price = price;
		this.status = status;
	}

	public int getAccession_no() {
		return accession_no;
	}

	public void setAccession_no(int accession_no) {
		this.accession_no = accession_no;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
