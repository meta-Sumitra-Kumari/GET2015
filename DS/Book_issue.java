import java.util.Date;

/**
 * @author Sumitra this is the POJO class for book_issue.
 */
public class Book_issue {
	Date dateFormat;
	int accession_no;
	int member_id;

	public Book_issue(java.sql.Date date, int accession_no, int member_id,
			Date due_dt) {
		super();
		this.dateFormat = date;
		this.accession_no = accession_no;
		this.member_id = member_id;
		this.due_dt = due_dt;
	}

	public Date getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(Date dateFormat) {
		this.dateFormat = dateFormat;
	}

	public int getAccession_no() {
		return accession_no;
	}

	public void setAccession_no(int accession_no) {
		this.accession_no = accession_no;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public Date getDue_dt() {
		return due_dt;
	}

	public void setDue_dt(Date due_dt) {
		this.due_dt = due_dt;
	}

	Date due_dt;

}
