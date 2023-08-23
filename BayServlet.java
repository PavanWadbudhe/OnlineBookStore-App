package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/bay")
public class BayServlet extends HttpServlet{
   @SuppressWarnings("unchecked")
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   HttpSession hs=req.getSession(false);
	   if(hs==null) {
		   pw.println("Session Expired...<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }else {
		   ArrayList<BookBean> ali=(ArrayList<BookBean>)hs.getAttribute("ali");
		   ali.forEach((k)->{
			   pw.println("TotalAmount :"+k.getbPrice()+"<br>");
			   ReduceBookDAO rbd=new ReduceBookDAO();
			   int z=rbd.update(req);
			   if(z>0) {
				   pw.println("Bayed Successfully...<br>");
			   }
		   });
		   RequestDispatcher rd=req.getRequestDispatcher("link1.html");
		   rd.include(req, res);
	   }
   }
}
