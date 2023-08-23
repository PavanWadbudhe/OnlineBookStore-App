package test;
import java.sql.*;
import javax.servlet.http.*;
public class ReduceBookDAO {
  public int k=0;
  public int update(HttpServletRequest req) {
	  try {
		  Connection con=DBConnection.getCon();
		  PreparedStatement ps=con.prepareStatement("Update BookDetails52 set bQty=bQty-1 where bId=?");
		  ps.setString(1, req.getParameter("bId"));
		  k=ps.executeUpdate();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return k;
  }
}
