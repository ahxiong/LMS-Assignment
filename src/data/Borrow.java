package data;

/**
 * Created by Mister_Brown on 4/17/2017.
 */
public class Borrow {
    int BorrowID;
	int BookID;
    int MemberID;
    String BorrowDate;
    String ReturnDate;
    int Qty;

    public Borrow(){}
    
    public Borrow(int id,int bookID, int memberID, String boorowDate, String returnDate, int qty) {
        BorrowID =id;
    	BookID = bookID;
        MemberID = memberID;
        BorrowDate = boorowDate;
        ReturnDate = returnDate;
        Qty = qty;
    }

    public String[] GetData(){
        return new String[]{
                BookID+"",
                MemberID+"",
                BorrowDate,
                ReturnDate,
                Qty+""
        };
    }
    
    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) {
        MemberID = memberID;
    }

    public String getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        BorrowDate = borrowDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }
}
