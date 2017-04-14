package form;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import component.*;
import java.awt.*;

public class BookForm {
	public void AddBooks(JFrame parent){
        int frameWidth =798;
        int frameHeight =700;
        int spacing =75;
        

        JDialog dialog = new JDialog(parent);
        dialog.setResizable(false);
        dialog.setTitle("ADDING NEW BOOK(S)");
        JPanel frame = new JPanel();

        frame.setLayout(null);
        frame.setBackground(new Color(236, 236, 236));
        frame.setSize(frameWidth,frameHeight);

        MLabel title = new MLabel(0, 175, frame.getWidth(), 50, "ADDING NEW BOOK(S)");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(248, 249, 250));
        title.setFont(new Font("Consolas", Font.BOLD, 35));

        ImageIcon images = new ImageIcon("src/picture/adds.png");
        MLabel image = new MLabel(0, 0, images.getIconWidth(), images.getIconHeight(), images);

        MLabel lblBookName = new MLabel(55, 258, 705, 25, "Book Title");
        MTextField txtBookName = new MTextField(48, 282, 705, 40);

        MLabel lblISBN = new MLabel(55, 258 + spacing, 300, 25, "ISBN");
        MTextField txtISBN = new MTextField(48, 282 + spacing, 300, 40);

        MLabel lblAccessionCode = new MLabel(55, 258 + spacing * 2, 300, 25, "Accession Code");
        MTextField txtAccessionCode = new MTextField(48, 282 + spacing * 2, 300, 40);

        MLabel lblLanguage = new MLabel(55, 258 + spacing * 3, 300, 25, "Language");
        MTextField txtLanguage = new MTextField(48, 282 + spacing * 3, 300, 40);

        MLabel lblQuantity = new MLabel(55, 258 + spacing * 4, 300, 25, "Quantity");
        MTextField txtQuantity = new MTextField(48, 282 + spacing * 4, 300, 40);



        MLabel lblCategory = new MLabel(460, 258 + spacing, 300, 25, "Category");
        MTextField txtCategory = new MTextField(453, 282 + spacing, 300, 40);

        MLabel lblAuthor = new MLabel(460, 258 + spacing * 2, 300, 25, "Author");
        MTextField txtAuthor = new MTextField(453, 282 + spacing * 2, 300, 40);

        MLabel lblYear = new MLabel(460, 258 + spacing * 3, 300, 25, "Year\\Edition");
        MTextField txtYear = new MTextField(453, 282 + spacing * 3, 300, 40);

        frame.setLocation(MFrame.CenterScreen(frame));

        
        
//       the two button ADD and CANCEL
         MButton btnCancel = new MButton(453, 282 + spacing * 4, 135, 40, "Cancel");
         MButton btnAdd = new MButton(453 + 165, 282 + spacing * 4, 135, 40, "Add");

             frame.add(btnAdd);
             frame.add(btnCancel);
        
        frame.add(title);
        frame.add(image);

        frame.add(lblCategory);
        frame.add(txtQuantity);
        frame.add(lblQuantity);
        frame.add(txtCategory);
        frame.add(lblAuthor);
        frame.add(txtAuthor);
        frame.add(lblYear);
        frame.add(txtYear);
        frame.add(lblBookName);
        frame.add(txtLanguage);
        frame.add(lblLanguage);
        frame.add(lblISBN);
        frame.add(txtAccessionCode);
        frame.add(lblAccessionCode);
        frame.add(txtISBN);
        frame.add(lblISBN);
        frame.add(txtBookName);

        frame.setVisible(true);
        dialog.add(frame);
        dialog.setSize(frame.getSize());
        dialog.setLocationRelativeTo(frame);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
	
    public static void SearchBook(JFrame parent){
        int frameWidth =700;
        int frameHeight =798;
        int spacing =75;
        int adjust =65;

        JDialog dialog = new JDialog(parent);
        dialog.setSize(new Dimension(frameHeight,frameWidth));
        dialog.setLayout(new BorderLayout(20,10));
        dialog.setTitle("SEARCH/ UPDATE/ DELETE BOOK(S)" );

        JPanel frame = new JPanel(new BorderLayout());
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
        frame.setSize(frameWidth,frameHeight);

        JPanel topPanel = new JPanel();
        MTextField txtSearch = new MTextField();
        txtSearch.setText("Search for ....");
        MComboBox cbType= new MComboBox();
        MButton btnSearch = new MButton("Search");

        topPanel.setBorder(new EmptyBorder(20,0,5,0));
        topPanel.add(txtSearch,BorderLayout.CENTER);
        topPanel.add(cbType,BorderLayout.CENTER);
        topPanel.add(btnSearch,BorderLayout.CENTER);

        cbType.addItem(" Filter By");
        
        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        String data[] = 
                {"Kathy", "Smith","Snowboarding", "5", "False"};


       
    		
    		
    		MTable tbl = new MTable(columnNames);
    		for(int i=0;i<30;i++)
    			tbl.addRow(data);
    		tbl.setAutoResizeWidth();
    		
    	tbl.setBorder(new CompoundBorder(
    			new EmptyBorder (20,20,0,20),
    			new MatteBorder(2,2,2,2,Color.BLACK)
    			));
    	
    	
    	JPanel bottomPanel = new JPanel();
    		MButton btnUpdateBook= new MButton("UPDATE");
    			btnUpdateBook.setFont(new Font("arial", Font.BOLD, 18));
    		MButton btnDeleteBook= new MButton("DELETE");
    			btnDeleteBook.setFont(new Font("arial", Font.BOLD, 18));
    			
    	bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	bottomPanel.add(btnUpdateBook);
    	bottomPanel.add(btnDeleteBook);
    	bottomPanel.setBorder(new EmptyBorder(20,20,20,20));
    	
    	dialog.add(tbl,BorderLayout.CENTER);
    	dialog.add(bottomPanel,BorderLayout.SOUTH);
        dialog.add(topPanel, BorderLayout.PAGE_START);
        dialog.setVisible(true);
    }



}
