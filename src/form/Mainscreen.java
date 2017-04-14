package form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import component.*;

public class Mainscreen {
	MLabel title;
    ImageIcon libraryLogo;
    ImageIcon book;
    ImageIcon borrow;
    ImageIcon returns;
    ImageIcon student;
    ImageIcon addBookLogo;
    ImageIcon viewBookLogo;
    ImageIcon addMemberLogo;
    ImageIcon viewMemberLogo;
    JPanel center;
    JPanel south;
    MLabel mainMenu;
    CardLayout cardLayout;
    JPanel mainPanel;
    JPanel memberPanel;
    JPanel bookPanel;
    MRadioButton btnBook; 
    MRadioButton btnMember;
    MRadioButton btnBorrow;
    MRadioButton btnReturn;
    MButton about;
    MRadioButton btnAddBook;
    MRadioButton btnViewBook;
    MRadioButton btnAddMember;
    MRadioButton btnViewMember;
    JPanel cardPanel;
    
	
	
	public Mainscreen(){
		JFrame frame = new JFrame();
		frame.setSize(1000,550);
		frame.setMinimumSize(new Dimension(890,510));
		frame.setLayout(new BorderLayout());
		frame.setTitle("LIBRARY MANAGEMENT SYSTEM");
		title = new MLabel("<html><strong>LIBRARY MANAGEMENT SYSTEM</strong><br>powered by group5 of scholarship class</html>");
		title.setHorizontalAlignment(JLabel.CENTER);
		libraryLogo = new ImageIcon("src/picture/lmslogo.png");
		title.setIcon(libraryLogo);
		title.setIconTextGap(30);
		title.setFont(new Font("Consolas", Font.PLAIN, 25));
		
		center = new JPanel();
		center.setLayout(new BorderLayout());
		mainMenu = new MLabel("<html><strong><u>MAIN-MENU</u></strong></html>");
		mainMenu.setFont(new Font("Consolas", Font.PLAIN, 35));
		center.add(mainMenu,BorderLayout.NORTH);
		
		south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		about = new MButton("ABOUT US");
		south.setBorder(new EmptyBorder(20,20,20,30));
		south.add(about);
		
		/*initMenu*/
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,4));
		btnBook = new MRadioButton("Book Management");
		book = new ImageIcon("src/picture/book.png");
		btnBook.setIcon(book);
		mainPanel.add(btnBook);
		
		btnMember = new MRadioButton("Member Management");
		student = new ImageIcon("src/picture/student.png");
		btnMember.setIcon(student);
		mainPanel.add(btnMember);
		
		btnBorrow = new MRadioButton("Borrowing Books");
		borrow = new ImageIcon("src/picture/borrow.png");
		btnBorrow.setIcon(borrow);
		mainPanel.add(btnBorrow);
		
		btnReturn = new MRadioButton("return Books");
		returns = new ImageIcon("src/picture/return.png");
		btnReturn.setIcon(returns);
		mainPanel.add(btnReturn);
		mainPanel.setBorder(new EmptyBorder(40,40,40,40));
	
		/*memberPanel*/
		memberPanel = new JPanel(new GridLayout(1,2));
		btnAddBook = new MRadioButton("Add Book(s)");
		addBookLogo = new ImageIcon("src/picture/book.png");
		btnAddBook.setIcon(addBookLogo);
		memberPanel.add(btnAddBook);

		btnViewBook = new MRadioButton("Search/Update/Delete Book(s)");
		viewBookLogo = new ImageIcon("src/picture/book.png");
		btnAddBook.setIcon(viewBookLogo);
		memberPanel.add(btnViewBook);
		memberPanel.setBorder(new EmptyBorder(40,40,40,40));
						
		
		/*bookPanel*/
		bookPanel = new JPanel(new GridLayout(1,2));
		btnAddBook = new MRadioButton("Add Book(s)");
		addBookLogo = new ImageIcon("src/picture/addbook.png");
		btnAddBook.setIcon(addBookLogo);
		bookPanel.add(btnAddBook);

		btnViewBook = new MRadioButton("Search/Update/Delete Book(s)");
		viewBookLogo = new ImageIcon("src/picture/viewbook.png");
		btnViewBook.setIcon(viewBookLogo);
		bookPanel.add(btnViewBook);
		bookPanel.setBorder(new EmptyBorder(40,40,40,40));		
		
		/*memberPanel*/
		
		memberPanel = new JPanel(new GridLayout(1,2));
		btnAddMember = new MRadioButton("Add Member(s)");
		addMemberLogo = new ImageIcon("src/picture/addmember.png");
		btnAddMember.setIcon(addMemberLogo);
		memberPanel.add(btnAddMember);

		btnViewMember = new MRadioButton("Search/Update/Delete Member(s)");
		viewMemberLogo = new ImageIcon("src/picture/viewmember.png");
		btnViewMember.setIcon(viewMemberLogo);
		memberPanel.add(btnViewMember);
		memberPanel.setBorder(new EmptyBorder(40,40,40,40));		
		
		cardPanel = new JPanel();
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		cardPanel.setBackground(Color.black);
		cardPanel.add(mainPanel,"mainPanel");
		cardPanel.add(memberPanel,"memberPanel");
		cardPanel.add(bookPanel,"bookPanel");
		center.add(cardPanel, BorderLayout.CENTER);
		
		btnMember.addActionListener(e->{
			cardLayout.show(cardPanel, "memberPanel");
			mainMenu.setText("<html><strong><u>MEMBER-MANAGEMENT</u></strong></html>");
			about.setText("GO BACK");
		});
		
		btnBook.addActionListener(e->{
			cardLayout.show(cardPanel, "bookPanel");
			mainMenu.setText("<html><strong><u>BOOK-MANAGEMENT</u></strong></html>");
			about.setText("GO BACK");
		});
		
		
		
		
		/*Form Object*/
		BookForm bf = new BookForm();
		ReturnForm rf = new ReturnForm();
		BorrowForm bof = new BorrowForm();
		MemberForm mf = new MemberForm();
		MOptionPane op = new MOptionPane();
		
		about.addActionListener(e->{
			if(about.getText().contains("GO BACK")){
				cardLayout.show(cardPanel, "mainPanel");
				about.setText("ABOUT US");
				mainMenu.setText("<html><strong><u>MAIN-MENU</u></strong></html>");
			}
			else{
				op.show(frame,"ABOUT US!","CREATED BY SAMRITH-YOEUN");
			}
		});
		
		btnAddMember.addActionListener(e->{
			mf.addMember(frame);
			
		});
		
		btnAddBook.addActionListener(e->{
			
			bf.AddBooks(frame);
		});
		
		btnBorrow.addActionListener(e->{
			
			bof.BorrowBook(frame);
		});
		
		btnReturn.addActionListener(e->{
			
			rf.ReturnBook(frame);
		});
		
		btnViewBook.addActionListener(e->{
			bf.SearchBook(frame);
		});
		
		btnViewMember.addActionListener(e->{
			mf.SearchMember(frame);
		});
		frame.add(south,BorderLayout.SOUTH);
		frame.add(center,BorderLayout.CENTER);
		frame.add(title,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
	
	
	
	public static void main(String arg[]){
		new Mainscreen();
	}


	
}
