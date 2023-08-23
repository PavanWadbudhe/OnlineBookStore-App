package test;
import java.sql.*;
import java.util.*;
public class ViewBookDAO {
    public ArrayList<BookBean> al=new ArrayList<BookBean>();
    public ArrayList<BookBean> retrieve(){
    	try {
    		Connection con=DBConnection.getCon();
    		PreparedStatement ps=con.prepareStatement("select * from BookDetails52");
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    			BookBean bb=new BookBean();
    			bb.setbId(rs.getString(1));
    			bb.setbName(rs.getString(2));
    			bb.setbAuthor(rs.getString(3));
    			bb.setbPrice(rs.getFloat(4));
    			bb.setbQty(rs.getInt(5));
    			al.add(bb);
    		}
    	}catch(Exception e) {e.printStackTrace();}
    	return al;
    }
}
