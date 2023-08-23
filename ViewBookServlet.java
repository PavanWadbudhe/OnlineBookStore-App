package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBookServlet extends HttpServlet{
   protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw=res.getWriter();
	   res.setContentType("text/html");
	   HttpSession hs=req.getSession(false);
	   if(hs==null) {
		   pw.println("Session Expired...<br>");
		   RequestDispatcher rd=req.getRequestDispatcher("login.html");
		   rd.include(req, res);
	   }else {
		   UserBean ub=(UserBean)hs.getAttribute("ub");
		   pw.println("Page Belongs to :"+ub.getfName()+"<br>");
		   ArrayList<BookBean> al=new ViewBookDAO().retrieve();
		   hs.setAttribute("al", al);
		   if(al.size()==0) {
			   pw.println("No Books are Available...<br>");
		   }else {
			   al.forEach((k)->{
					  BookBean bb=(BookBean)k; 
					  pw.println(bb.getbId()+"&nbsp&nbsp&nbsp"+
					             bb.getbName()+"&nbsp&nbsp&nbsp"+
							     bb.getbAuthor()+"&nbsp&nbsp&nbsp"+
					             bb.getbPrice()+"&nbsp&nbsp&nbsp"+
							     bb.getbQty()+"&nbsp&nbsp&nbsp"+
					             "<a href='addcart?bId="+bb.getbId()+"'>AddToCart</a><br>"
					  );
				   });
		   }
		   
		   pw.println("<a href='viewcart'>ViewCart</a>"+
		              "&nbsp&nbsp&nbsp"+"<a href='logout'>Logout</a>");
	   }
   }
}
