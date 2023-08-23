package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet{
   @SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   HttpSession hs=req.getSession(false);
	   if(hs==null) {
		   pw.println("Session Expired...<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }else {
		   ArrayList<BookBean> ali=(ArrayList<BookBean>)hs.getAttribute("ali");
		   if(ali==null) {
			   pw.println("Cart is Empty...<br>");
			   pw.println("<a href='link1.html'>Back</a>");
		   }
		   else if(ali.size()==0) {
			   pw.println("Cart is Empty...<br>");
			   
		   }else {
			   ali.forEach((k)->{
					  pw.println(k.getbId()+"&nbsp&nbsp&nbsp"+
							     k.getbName()+"&nbsp&nbsp&nbsp"+
							     k.getbAuthor()+"&nbsp&nbsp&nbsp"+
							     k.getbPrice()+"&nbsp&nbsp&nbsp"+
							     k.getbQty());
					   pw.println("<form action='bay' method='post'>");
					   pw.println("<input type='hidden' name='bId' value='"+k.getbId()+"'/>");
					   pw.println("<input type='submit' value='Bay'/>");
					   pw.println("</form>");
				   });
		   }
	   }
   }
}
