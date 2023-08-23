package test;
import java.io.*;
@SuppressWarnings("serial")
public class BookBean implements Serializable{
   private String bId,bName,bAuthor;
   private float bPrice;
   private int bQty;
   public BookBean() {}
public String getbId() {
	return bId;
}
public void setbId(String bId) {
	this.bId = bId;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getbAuthor() {
	return bAuthor;
}
public void setbAuthor(String bAuthor) {
	this.bAuthor = bAuthor;
}
public float getbPrice() {
	return bPrice;
}
public void setbPrice(float bPrice) {
	this.bPrice = bPrice;
}
public int getbQty() {
	return bQty;
}
public void setbQty(int bQty) {
	this.bQty = bQty;
}
   
}
