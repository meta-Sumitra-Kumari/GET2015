

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String error="";
		String firstname=request.getParameter("firstname");
		if(isAlpha(firstname)){
			
			System.out.println(firstname);
		}
		
		else
		{
			error+="invalid name!!! name should conatin only alphabets \n";
			
		}
		String lastname=request.getParameter("lastname");
		if(isAlpha(lastname)){
			
			System.out.println(lastname);
		}
		else
		{
			error+="invalid name!!! name should conatin only alphabets \n";
		}
		String[] gender=request.getParameterValues("Gender");
		
		String day=request.getParameter("day");
		System.out.println(day);
		String year=request.getParameter("Year");
		System.out.println(year);
		String[] month=request.getParameterValues("month");
		int date=Integer.parseInt(day);
		System.out.println(date);
		int yeara=Integer.parseInt(year);
		System.out.println(yeara);
		for(String montha : month){
			
			
			if(montha.equalsIgnoreCase("february")){
				
				
				if(yeara%4!=0)
				{
					if(date>28)
					{
						error+="date is invalid\n";
					}
					
				}
				else if(yeara%4==0)
				{
					if(date>29)
					{
						error+="date is invalid\n";
					}
					
			}
			}
			else
			if(montha.equalsIgnoreCase("April")||montha.equalsIgnoreCase("june")||montha.equalsIgnoreCase("september")||montha.equalsIgnoreCase("november")){
				if(date>30)
				{
					error+="date is invalid\n";
				}
				
			}
			else{
				if(date>31)
				{
					error+="date is invalid\n";
				}
				
			
		}
		
		String[] country=request.getParameterValues("country");
		
		String id=request.getParameter("emailid");
		if(isid(id)){
			
			System.out.println(id);
		}
		else
		{
			error+="invalid email id\n";
		}
		String[] mail=request.getParameterValues("email");
		
		String password=request.getParameter("passwrd");
		if(!(password.length()>8)){
			error+="length of password must be greater than 8 \n";
		}
		String confirmPassword=request.getParameter("repasswrd");
		if(!password.equals(confirmPassword))
		{
			error+="passaord Does't matched\n";
			System.out.println(password+"\n"+confirmPassword);
		}
		String alternateid=request.getParameter("alternateEmail");
		if(isemail(alternateid)){
			
			System.out.println(alternateid);
		}else
		{
			error+="invalid alternate email id!!\n";
		}
		String[] question1=request.getParameterValues("question1"); 
		
		String ans1=request.getParameter("ans1");
		if(isAlpha(ans1)){
			
			System.out.println(ans1);
		}
		else{
			error+="invalid answer1 \n";
		}
		String[] question2=request.getParameterValues("question2");
		
		String ans2=request.getParameter("ans2");
		if(isAlpha(ans2)){
			
			System.out.println(ans2);
		}else
		{
			error+="invalid ans \n";
		}
		
		if(error.length()>0)
		{
			out.println("<h3>Invalid value entered</h3>");
			out.write(error);
		}
		else{
			response.setContentType("text/html");
			out.println("<h3>Successlly Registered</h3>");
			out.println("<table><tr>");
			out.println("<td>First name</td><td>");
			out.write(firstname);
			out.println("</td></tr><tr>");
			out.println("<td>Last Name</td><td>");
			out.write(lastname);
			out.println("</td></tr><tr>");
			out.println("<td>Gender</td><td>");
			for(String gen : gender){
				out.write(gen);
			}
			out.println("</td></tr><tr>");
			out.println("<td>DOB</td><td>");
			for(String montha1 : month){
			out.print("DOB     "+date+"-"+montha1+"-"+yeara+"\n");
			}
			out.println("</td></tr><tr>");
			out.println("<td>Country</td><td>");
			for(String countrya : country){
				out.write(countrya);
				
			}
			out.println("</td></tr><tr>");
			out.println("<td>Email id</td><td>");
			out.write(id+"@");
			for(String idA : mail){
				out.write(idA);
			}
			out.println("</td></tr><tr>");
			out.println("<td>Alternate email id</td><td>");
			out.write(alternateid);
			out.println("</td></tr><tr>");
			out.println("<td>Question 1</td><td>");
			for(String qu1 : question1){
				out.write(qu1);
			
			}
			out.println("</td></tr><tr>");
			out.println("<td>Answer 1</td><td>");
			out.write(ans1);
			out.println("</td></tr><tr>");
			out.println("<td>Question 2</td><td>");
			for(String qu2 : question2){
				out.write(qu2+"\n");
			}
			out.println("</td></tr><tr>");
			out.println("<td>Answer 2</td>");
			out.write(ans2);
			out.println("</td></tr></table>");
		}
	}}
	
	boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	boolean isid(String name) {
	    return name.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)$");
	}
	boolean isemail(String name) {
	    return name.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
