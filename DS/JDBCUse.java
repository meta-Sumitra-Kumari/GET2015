import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sumitra
 * 
 */
public class JDBCUse {

	public static void main(String arg[]) {
		Scanner scanner = new Scanner(System.in);
		JDBCUse jdbcObject = new JDBCUse();
		char choice;
		do {
			System.out.println("menu:-");
			System.out.println("1-to Show book of author");
			System.out.println("2-to issue book");
			System.out
					.println("3-to delete books that are not issued from last one year");
			System.out.println("want to continue(y/n)");

			choice = scanner.next().charAt(0);
			switch (choice) {
			case 1:
				jdbcObject.executeQueryToPrintAuthorBook();
				// to show the book of author.
				break;
			case 2:
				jdbcObject.executeQueryToIssueBook();
				// to issue the book.
				break;

			case 3:
				System.out.println("No of books deleted"
						+ jdbcObject.executeQueryToDeleteBook());
				// to delete the books which are not issued.
				break;
			default:
				System.out.println("enter right choice");
				break;
			}
		} while (choice == 'Y' || choice == 'y');
	}

	/*
	 * Fetch all the books published by author, given the name of the author.
	 * Return the books data (List of Titles).
	 */
	private void executeQueryToPrintAuthorBook() {
		Connection con = null;
		Scanner scanner = new Scanner(System.in);
		Statement ps = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		System.out.println("Enter Author name");
		String author_name = scanner.nextLine();
		String query = "SELECT t.title_id,t.title_nm,t.subject_id,t.publisher_id FROM "
				+ "authors a INNER JOIN title_author ta ON a.author_id = ta.author_id "
				+ "INNER JOIN titles t WHERE (t.title_id=ta.title_id AND a.author_nm='"
				+ author_name + "')";
		/*
		 * Query to print the title name of book by the author using inner join.
		 */
		List<Titles> list = new ArrayList<Titles>();
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(query);
			while (rs.next()) {
				Titles title = new Titles(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				list.add(title);

			}
			/*
			 * Storing the result in list.
			 */
			System.out.println("Books are	:-");
			for (Titles titleObject : list) {
				System.out.println(titleObject.getTitle_nm());
			}
			/*
			 * to print the books.
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * Given the name of the book, to be issued by an existing member.Return
	 * flag to indicate whether the the book has been issued or not.
	 */
	private void executeQueryToIssueBook() {
		Connection con = null;
		Scanner scanner = new Scanner(System.in);
		Statement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		System.out.println("slect your name");
		String query = "SELECT * FROM MEMBERS";
		String querySecond = "SELECT * FROM titles";
		List<Members> membersList = new ArrayList<Members>();
		List<Titles> titleList = new ArrayList<Titles>();
		try {
			ps = con.createStatement();
			rs = ps.executeQuery(query);
			while (rs.next()) {
				Members member = new Members(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				membersList.add(member);
			}
			if (!membersList.isEmpty()) {
				System.out.println("member_Id		member_name");
				for (Members mem : membersList) {
					System.out.println(mem.getMember_id() + "		"
							+ mem.getMember_nm());
				}
			}
			/*
			 * printing the name of members who are already in library
			 * management as we can only issue book to those who are already
			 * registered.
			 */

			String name = scanner.nextLine();
			String queryAgain = "SELECT * FROM members WHERE member_nm=?";
			ps1 = con.prepareStatement(queryAgain);
			ps1.setString(1, name);
			rs = ps1.executeQuery();

			Members member = null;
			while (rs.next()) {
				member = new Members(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			rs = ps.executeQuery(querySecond);
			while (rs.next()) {
				Titles title = new Titles(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getInt(4));
				titleList.add(title);
			}
			if (!titleList.isEmpty()) {
				System.out.println("Title_Id		TItle_name");
				for (Titles tit : titleList) {
					System.out.println(tit.getTitle_id() + "		"
							+ tit.getTitle_nm());
				}

			}
			/*
			 * printing the name of book that are available with us.
			 */
			System.out.println("Enter book name");
			String book = scanner.nextLine();
			String queryA = "SELECT * FROM titles WHERE title_nm= ?";
			ps1 = con.prepareStatement(queryA);
			ps1.setString(1, book);
			rs = ps1.executeQuery();
			Titles title = null;
			while (rs.next()) {
				title = new Titles(rs.getInt(1), rs.getString(2), rs.getInt(3),
						rs.getInt(4));
			}
			String queryB = "SELECT * FROM books WHERE title_id=?";
			ps1 = con.prepareStatement(queryB);
			ps1.setInt(1, title.getTitle_id());
			rs = ps1.executeQuery();
			Book book1 = null;
			while (rs.next()) {
				book1 = new Book(rs.getInt(1), rs.getInt(2), rs.getDate(3),
						rs.getFloat(4), rs.getInt(5));
			}
			String queryc = "INSERT INTO book_issue (member_id,accession_no) VALUES("
					+ member.getMember_id()
					+ ","
					+ book1.getAccession_no()
					+ ")";
			if (book1.getStatus() == 0) {
				int i = ps.executeUpdate(queryc);
				/*
				 * updating in book_issue table
				 */
				if (i == 1) {
					System.out.println("book is issued");
					queryc = "UPDATE books SET status=1 WHERE accession_no="
							+ book1.getAccession_no();
					i = ps.executeUpdate(queryc);
					/*
					 * updating the status of book in book table;
					 */
					if (i == 1) {
						System.out.println("status updated");
					}

				} else {
					System.out.println("member cannot be inserted");
				}
			} else {
				System.out.println("book can't be issued");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * Delete all those books which were not issued in last 1 year. Return the
	 * number of books deleted.
	 * 
	 * @return no of books deleted.
	 */
	private int executeQueryToDeleteBook() {
		Connection con = null;
		Statement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		con = conUtil.getConnection();
		int count = 0;
		String query = "select distinct b.accession_no from book_issue bi right join books b on b.accession_no=bi.accession_no "
				+ "AND bi.Issue_dt=(Select max(Issue_dt) from book_issue bi1  "
				+ "where bi1.accession_no=bi.accession_no group by (bi1.accession_no)) "
				+ "Where((DATEDIFF( NOW(), bi.Issue_dt)>=365) or bi.issue_dt is null)";
		/*
		 * query to delete the book which is not issued in one year or never
		 * issued.
		 */
		String query1 = "Delete from books where accession_no=?";
		// deleting the book form table book
		String query2 = "Delete from book_issue where accession_no=?";
		// deleting the entry from book_issue
		String query3 = "Delete from book_return where accession_no=?";
		// deleting the book entry from book_return table.

		try {
			ps = con.createStatement();
			rs = ps.executeQuery(query);
			while (rs.next()) {
				ps1 = con.prepareStatement(query2);
				ps1.setInt(1, rs.getInt(1));
				ps1.executeUpdate();
				ps1 = con.prepareStatement(query3);
				ps1.setInt(1, rs.getInt(1));
				ps1.executeUpdate();
				ps1 = con.prepareStatement(query1);
				ps1.setInt(1, rs.getInt(1));

				count = count + ps1.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return count;

	}

}
