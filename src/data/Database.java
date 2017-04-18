package data;

import java.sql.*;

import javax.swing.JOptionPane;

import component.MOptionPane;

public class Database {
	static Connection connection;
	PreparedStatement ps;
	
	public static void main(String arg[]){
		Database data = new Database();
		data.connect();
		data.Update(new Book(1,"22123","44444","2224","235","236","2137","812",91));
		
	}
	
	public void connect(){
		System.out.print("start");
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/assignmentjava","root","");
			ps= connection.prepareStatement("SELECT * FROM user");
			ResultSet result = ps.executeQuery();
            if(result.next()){
                JOptionPane.showMessageDialog(null, "success");
            }
            else{
            	JOptionPane.showMessageDialog(null, "Connected but null");
            }
					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 public int Insert(Object object){
		 int rows = 0;
			try {				
				 PreparedStatement stmt = null;
				 System.out.println("Creating statement...");
				 String sql;
			     
				 if (object.getClass()==Book.class){
					 Book book = (Book)object;
					 sql = "INSERT INTO books VALUES (?,?,?,?,?,?,?,?,?)";
				      stmt = connection.prepareStatement(sql);
				      stmt.setInt(1, 0);
				      stmt.setString(2,book.getTitle());
				      stmt.setString(3,book.getIsbn());
				      stmt.setString(4,book.getCategory());
				      stmt.setString(5,book.getAccesscode());
				      stmt.setString(6,book.getAuthor());
				      stmt.setString(7,book.getLanguage());
				      stmt.setString(8,book.getEdition());
				      stmt.setInt(9, book.getQty());
				     
			     }
				 
				 else if(object.getClass()==Member.class){
					 Member member = (Member)object;
					 sql = "INSERT INTO members VALUES (?,?,?,?,?,?,?,?,?)";
				      stmt = connection.prepareStatement(sql);
				      stmt.setInt(1, 0);
				      stmt.setString(2,member.getName());
				      stmt.setString(3,member.getCardID());
				      stmt.setString(4,member.getGender());
				      stmt.setString(5,member.getRegisterDate());
				      stmt.setString(6,member.getExpireDate());
				      stmt.setString(7,member.getMobile());
				   	  stmt.setString(8,member.getEmail());
				   	  stmt.setString(9, member.getAddress());
				 }
				 
				 else if (object.getClass()==Return.class){
					 Return returns = (Return)object;
                     sql = "INSERT INTO returns VALUES (?,?,?,?,?,?)";
                       stmt = connection.prepareStatement(sql);
                       stmt.setInt(1, 0);
                       stmt.setInt(2,returns.getBookID());
                       stmt.setInt(3,returns.getMemberID());
                       stmt.setString(4,returns.getBorrowDate());
                       stmt.setString(5,returns.getReturnDate());
                       stmt.setInt(6,returns.getQty());
                       stmt.setDouble(7,returns.getFine());
				 }
				 
				 else if (object.getClass()==Borrow.class){
	                    Borrow borrow = (Borrow)object;
	                    sql = "INSERT INTO borrows VALUES (?,?,?,?,?,?)";
	                      stmt = connection.prepareStatement(sql);
	                      stmt.setInt(1, 0);
	                      stmt.setInt(2,borrow.getBookID());
	                      stmt.setInt(3,borrow.getMemberID());
	                      stmt.setString(4,borrow.getBorrowDate());
	                      stmt.setString(5,borrow.getReturnDate());
	                      stmt.setInt(6,borrow.getQty());        
				 }
				 
				  
			      rows = stmt.executeUpdate();
			      
			      
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rows;
	    }
	    
	 public void Update(Object object){
			try {				
				 PreparedStatement stmt = null;
				 System.out.println("Creating statement...");
				 String sql;
			     
				 if (object.getClass()==Book.class){
					 Book book = (Book)object;
					 sql = "UPDATE books SET Title =?, Isbn=?, Category=?, Accesscode=?, Author=?, Languages=?, Edition=?, Qty=? WHERE BookID =?";
				      stmt = connection.prepareStatement(sql);
				      stmt.setString(1,book.getTitle());
				      stmt.setString(2,book.getIsbn());
				      stmt.setString(3,book.getCategory());
				      stmt.setString(4,book.getAccesscode());
				      stmt.setString(5,book.getAuthor());
				      stmt.setString(6,book.getLanguage());
				      stmt.setString(7,book.getEdition());
				      stmt.setInt(8, book.getQty());
				      stmt.setInt(9, book.getBookID());
				     
			     }
				 
				 else if(object.getClass()==Member.class){
					 Member member = (Member)object;
					  sql = "UPDATE members SET Name=?, CardID=?, Gender=?, RegisterDate=?, ExpireDate=?, Mobile=?, Email=?,Address=? WHERE MemberID=?"; 
				      stmt = connection.prepareStatement(sql);
				      
				      stmt.setString(1,member.getName());
				      stmt.setString(2,member.getCardID());
				      stmt.setString(3,member.getGender());
				      stmt.setString(4,member.getRegisterDate());
				      stmt.setString(5,member.getExpireDate());
				      stmt.setString(6,member.getMobile());
				   	  stmt.setString(7,member.getEmail());
				   	  stmt.setString(8, member.getAddress());
				   	  stmt.setInt(9, member.getMemberID());
				 }
				 
				 else if (object.getClass()==Return.class){
					 Return returns = (Return)object;
                    sql = "UPDATE returns SET BookID=?, MemberID=?, BorrowDate=?, ReturnDate=?, Qty=?, Fine=? WHERE ReturnID=?";
                      stmt = connection.prepareStatement(sql);
                      stmt.setInt(1,returns.getBookID());
                      stmt.setInt(2,returns.getMemberID());
                      stmt.setString(3,returns.getBorrowDate());
                      stmt.setString(4,returns.getReturnDate());
                      stmt.setInt(5,returns.getQty());
                      stmt.setDouble(6,returns.getFine());
                      stmt.setInt(7,returns.getReturnID());
				 }
				 
				 else if (object.getClass()==Borrow.class){
	                    Borrow borrow = (Borrow)object;
	                    sql = "UPDATE borrows SET BookID=?, MemberID=?, BorrowDate=?, ReturnDate=?, Qty=? WHERE BorrowID=?";
	                      stmt = connection.prepareStatement(sql);
	                      stmt.setInt(1,borrow.getBookID());
	                      stmt.setInt(2,borrow.getMemberID());
	                      stmt.setString(3,borrow.getBorrowDate());
	                      stmt.setString(4,borrow.getReturnDate());
	                      stmt.setInt(5,borrow.getQty());
	                      stmt.setInt(6, 0);
				 }
				 
				  
			      int rows = stmt.executeUpdate();
			      System.out.println(rows);
			      
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	 
	 public int Delete(Object object){
		 int rows = 0;
			try {				
				 PreparedStatement stmt = null;
				 String sql;
			     
				 if (object.getClass()==Book.class){
					 Book book = (Book)object;
					 sql = "DELETE FROM books WHERE BookID = ?";
				      stmt = connection.prepareStatement(sql);
				      stmt.setInt(1,book.getBookID());
			     }
				 
				 else if(object.getClass()==Member.class){
					 Member member = (Member)object;
					 sql = "DELETE FROM members WHERE BookID = ?";
				      stmt = connection.prepareStatement(sql);
				      stmt.setInt(1,member.getMemberID());
				 }
			      rows = stmt.executeUpdate();
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rows;
	 } 
}


