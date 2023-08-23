package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/addcart")
public class AddToCartServlet extends HttpServlet{
  @SuppressWarnings("unchecked")
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  PrintWriter pw=res.getWriter();
	  res.setContentType("text/html");
	  ArrayList<BookBean> ali=new ArrayList<BookBean>();
	  HttpSession hs=req.getSession(false);
	  if(hs==null) {
		  pw.println("Session Expired...<br>");
		  RequestDispatcher rd=req.getRequestDispatcher("login.html");
		  rd.include(req, res);
	  }else {
		  String bId=req.getParameter("bId");
		  ArrayList<BookBean> al=(ArrayList<BookBean>)hs.getAttribute("al");
		  al.forEach((k)->{
			  if(bId.equals(k.getbId())) {
				  ali.add(k);
				  hs.setAttribute("ali", ali);
				  pw.println("Book Added to Cart Successfully...<br>");
			  }  
		  });
		  RequestDispatcher rd=req.getRequestDispatcher("link1.html");
		  rd.include(req, res);
	  }
   }
}
