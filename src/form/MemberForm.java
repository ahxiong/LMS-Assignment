package form;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import component.*;

public class MemberForm {
    
    public void addMember(JFrame parent){
        int frameWidth =798;
        int frameHeight =700;
        int spacing =75;
        int adjust = 65;
 
        JDialog dialog = new JDialog(parent);
        dialog.setResizable(false);
        JPanel frame = new JPanel();

        frame.setLayout(null);
        frame.setBackground(new Color(236, 236, 236));
        frame.setSize( frameWidth,frameHeight);

        dialog.setTitle("ADDING NEW MEMBER(S)");
        MLabel title = new MLabel(0, 175, frame.getWidth(), 50, "ADDING NEW MEMBER(S)");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBackground(new Color(248, 249, 250));
        title.setFont(new Font("Consolas", Font.BOLD, 35));

        ImageIcon images = new ImageIcon("src/picture/adds.png");
        MLabel image = new MLabel(0, 0, images.getIconWidth(), images.getIconHeight(), images);


        //Left side MemberName=International Standard Book Number, Book Name, RegisterDate, Mobile, Quantity
        MLabel lblMemberName = new MLabel(55, 258, 705, 25, "Member Name");
        MTextField txtMemberName = new MTextField(48, 282, 705, 40);


        MLabel lblMemberID = new MLabel(55, 258 + spacing, 300, 25, "Member ID");
        MTextField txtMemberID = new MTextField(48, 282 + spacing, 300, 40);

        MLabel lblRegisterDate = new MLabel(55, 258 + spacing * 2, 300, 25, "Register Date");
        MTextField txtRegisterDate = new MTextField(48, 282 + spacing * 2, 300, 40);

        MLabel lblMobile = new MLabel(55, 258 + spacing * 3, 300, 25, "Mobile");
        MTextField txtMobile = new MTextField(48, 282 + spacing * 3, 300, 40);

        MLabel lblEmail = new MLabel(55, 258 + spacing * 4, 300, 25, "Email");
        MTextField txtEmail = new MTextField(48, 282 + spacing * 4, 300, 40);



        MLabel lblGender = new MLabel(460, 258 + spacing, 300, 25, "Gender");
        MComboBox txtGender = new MComboBox(453, 282 + spacing, 300, 40,new String[]{" Male"," Female"});

        MLabel lblAddress = new MLabel(460, 258 + spacing * 2, 300, 25, "Address");
        MTextArea txtAddress = new MTextArea(453, 282 + spacing * 2, 300, 120);

        MLabel lblYear = new MLabel(460, 258 + spacing * 3, 300, 25, "Year\\Edition");
        MTextField txtYear = new MTextField(453, 282 + spacing * 3, 300, 40);

        frame.setLocation(MFrame.CenterScreen(frame));


            MLabel lblSearch = new MLabel(55 + adjust, 20, 500, 25, "Enter the MemberID");
            MTextField txtSearch = new MTextField(48 + adjust, 51, 400, 40);

            MButton btnSearch = new MButton(470 + adjust, 51, 135, 40, "Search");
//    the two button




//       the two button ADD and CANCEL
            MButton btnCancel = new MButton(453, 282 + spacing * 4, 135, 40, "Cancel");
            MButton btnAdd = new MButton(453 + 165, 282 + spacing * 4, 135, 40, "Add");

            frame.add(btnAdd);
            frame.add(btnCancel);
            frame.repaint();
        

            if(parent ==null){
             	dialog.setTitle("UPDATING MEMBER(S)");
             	title.setText("UPDATE THE MEMBER(S)");
     		        }
// will display for the update and add but just different time
        frame.add(title);
        frame.add(image);

        frame.add(lblGender);
        frame.add(txtGender);
        frame.add(lblAddress);
        frame.add(txtAddress);
        frame.add(lblYear);
        frame.add(txtYear);
        frame.add(lblMemberName);
        frame.add(txtMobile);
        frame.add(lblMobile);
        frame.add(lblMemberID);
        frame.add(txtRegisterDate);
        frame.add(lblRegisterDate);
        frame.add(txtMemberID);
        frame.add(lblMemberID);
        frame.add(txtMemberName);
        frame.add(lblEmail);
        frame.add(txtEmail);

        frame.setVisible(true);

        dialog.add(frame);
        dialog.setSize(frame.getSize());
        dialog.setLocationRelativeTo(frame);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
    

    public static void SearchMember(JFrame parent){
        int frameWidth =1000;
        int frameHeight =700;
        int spacing =75;
        int adjust =65;

        JDialog dialog = new JDialog(parent);
        dialog.setSize(new Dimension(frameHeight,frameWidth));
        dialog.setLayout(new BorderLayout(20,10));
        dialog.setTitle("SEARCH/ UPDATE/ DELETE MEMBER(S)" );
        dialog.setSize(frameWidth,frameHeight);

        JPanel frame = new JPanel(new BorderLayout());
        frame.setLayout(null);
        frame.setBackground(Color.WHITE);
        

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
        
        String[] columnNames = {
    			"ID",
    			"NAME",
    			"GENDER",
    			"REGISTER",
    			"PHONE NUMBER",
    			"EMAIL",
    			"ADDRESS"};

    String data[] = 
            	{	"A001",
            		"YOEUN SAMRITH", 
            		"male",
            		"10/29/2013",
            		"010532524",
            		"samrith.yoeun@gmail.com",
            		"Phnom Penh"};



       
    		
    		
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
