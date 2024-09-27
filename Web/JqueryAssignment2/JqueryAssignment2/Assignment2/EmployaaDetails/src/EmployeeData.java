

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EmployeeData
 */
@WebServlet("/EmployeeData")
public class EmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empName = request.getParameter("name");

		String detail = "";
		switch(empName)
		{
		case "Sumitra": detail="Name: Sumitra Age:22 Dob:02-06-1993  Address:Udaipur";break;
		case "Anshita": detail="Name: Anshita Arya Age:22 Dob:19-09-1992  Address:Bihar";break;
		case "Deepali": detail="Name: Deepali Baldi Age:22 Dob:19-09-1992  Address:Neemuch";break;
		case "Arushi": detail="Name: Arushi Jain Age:22 Dob:19-09-1994  Address:Jhotwara";break;
		}
		

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(detail);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
