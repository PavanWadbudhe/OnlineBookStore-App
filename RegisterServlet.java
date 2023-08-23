package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   UserBean ub=new UserBean();
	   ub.setuName(req.getParameter("uname"));
	   ub.setpWord(req.getParameter("pword"));
	   ub.setfName(req.getParameter("fname"));
	   ub.setlName(req.getParameter("lname"));
	   ub.setAddr(req.getParameter("addr"));
	   ub.setmId(req.getParameter("mid"));
	   ub.setPhNo(Long.parseLong(req.getParameter("phno")));
	   
	   int k=new UserRegDAO().register(ub);
	   if(k>0) {
		   pw.println("User Registered Successfully...<br>");
	   }
	   RequestDispatcher rd=req.getRequestDispatcher("login.html");
	   rd.include(req, res);
   }
}
