package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   UserBean ub=new UserLoginDAO().login(req);
	   if(ub==null) {
		   pw.println("Invalid Login process...<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }else {
		   HttpSession hs=req.getSession();
		   hs.setAttribute("ub",ub);
		   pw.println("Welcome User :"+ub.getfName()+"<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("link1.html");
		   rd.include(req, res);
	   }
   }
}
